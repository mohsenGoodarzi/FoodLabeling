package com.nutrition.information.persistence;


import java.util.List;

import org.springframework.data.annotation.Persistent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.nutrition.information.entities.Food;


@Persistent
public interface FoodDao extends JpaRepository<Food,String>{
	
	@Query(value="from food",nativeQuery = true)
	public List<Food> getAllFoods();
	
	@Query(value ="from food where food_id = :foodId",nativeQuery = true)
	public Food getFood(@Param("foodId") String foodId);
	
	@Transactional
	@Modifying
	@Query(value = "insert into food (food_id,dish_type_id,cuisine_type_id,food_type)values(:foodId,:dishTypeId,:cuisineTypeId,:foodType)",nativeQuery = true)
	public int insert(@Param("foodId")String foodId, @Param("dishTypeId")String dishTypeId,@Param("cuisineTypeId")String cuisineTypeId,@Param("foodType") String foodType);
	
	@Transactional
	@Modifying
	@Query(value="update food set dish_type_id = :dishTypeId, cuisine_type_id = :cuisineTypeId,food_type = :foodType  where food_id = :foodId", nativeQuery = true)
	public int update(@Param("foodId")String foodId, @Param("dishTypeId")String dishTypeId,@Param("cuisineTypeId")String cuisineTypeId,@Param("foodType") String foodType);  
	
	@Transactional
	@Modifying
	@Query(value = "delete from food where food_id = :foodId", nativeQuery = true)
	public int delete(@Param("foodId") String foodId);
	
}
