package com.nutrition.information.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nutrition.information.entities.FoodIngredient;
import com.nutrition.information.entities.FoodIngredientId;

import jakarta.transaction.Transactional;
import lombok.experimental.PackagePrivate;

@Repository
public interface FoodIngredientDao extends JpaRepository<FoodIngredient,FoodIngredientId> {

	@Transactional
	@Modifying
	@Query(value="insert into food_ingredient(food_id,ingredient_id,unit_id,amount)values(:foodId,:ingredientId,:unitId,:amount)",nativeQuery = true)
	public int insert(@Param("ingredientId") String ingredientId,@Param("foodId") String foodId,@Param("amount") float amount,@Param("unitId") String unitId);
	
	@Transactional
	@Modifying
	@Query(value="update food_ingredient set unit_id = :unitId, amount = :amount where food_id = :foodId and ingredient_id = :ingredientId",nativeQuery = true)
	public int update(@Param("ingredientId") String ingredientId,@Param("foodId") String foodId ,@Param("unitId") String unitId, @Param("amount") float amount);
	
	@Transactional
	@Modifying
	@Query(value="delete from food_ingredient where ingredient_id = :ingredientId and food_id = :foodId",nativeQuery = true)
	public int delete(@Param("ingredientId")String ingredientId, @Param("foodId")String foodId);
	
}
