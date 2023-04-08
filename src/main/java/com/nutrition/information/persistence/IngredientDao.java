package com.nutrition.information.persistence;


import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nutrition.information.entities.Ingredient;




@Repository
public interface IngredientDao extends JpaRepository<Ingredient,String>{

	@Query(value="from Ingredient")
	public List<Ingredient> getAllIngredients();
	
	@Query(value="from Ingredient where ingredientId = :ingredientId")
	public Ingredient getIngredient(String ingredientId); 
	
	@Transactional
	@Modifying
	@Query(value="insert into Ingredient (IngredientId, IngredientType, UnitId,"+
			"Amount, Fat, Carb, Protein, Calory, WarningId) "+
			"values (:ingredientId, :ingredientType, :unitId, "
			+ ":amount, :fat, :carb, :protein, :calory, :warningId)", nativeQuery=true)
	public int insert(String ingredientId, String ingredientType, String unitId, 
			float amount,float fat, float carb, float protein , float calory, String warningId);

	@Transactional
	@Modifying
	@Query(value="update Ingredient set IngredientType = :ingredientType, UnitId = :unitId,"+
			"Amount = :amount, Fat = :fat, Carb = :carb, Protein = :protein, Calory = :calory, WarningId = :warningId where IngredientId = :ingredientId", nativeQuery=true)
	public int update(String ingredientId,String ingredientType, String unitId, 
			float amount,float fat, float carb, float protein , float calory, String warningId);

	@Transactional
	@Modifying
	@Query(value="delete from Ingredient where IngredientId = :ingredientId", nativeQuery=true)
	public int delete(String ingredientId);

}
