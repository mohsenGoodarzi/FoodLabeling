package com.nutrition.information.persistence;

import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.data.annotation.Persistent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.nutrition.information.entities.Ingredient;

@Persistent
public interface IngredientDao extends JpaRepository<Ingredient, String> {

	@Query(value = "from Ingredient")
	public List<Ingredient> getAllIngredients();

	@Query(value = "from Ingredient where ingredientId = :ingredientId")
	public Ingredient getIngredient(@Param("ingredientId") String ingredientId);

	@Transactional
	@Modifying
	@Query(value = "insert into ingredient (IngredientId, ingredient_type, unit_id,"
			+ "amount, fat, carb, protein, calory, warning_id) " + "values (:ingredientId, :ingredientType, :unitId, "
			+ ":amount, :fat, :carb, :protein, :calory, :warningId)", nativeQuery = true)
	public int insert(@Param("ingredientId") String ingredientId, @Param("ingredientType") String ingredientType,
			@Param("unitId") String unitId, @Param("amount") float amount, @Param("fat") float fat,
			@Param("carb") float carb, @Param("protein") float protein, @Param("calory") float calory,
			@Param("warningId") String warningId);

	@Transactional
	@Modifying
	@Query(value = "update ingredient set ingredient_type = :ingredientType, unit_id = :unitId,"
			+ "amount = :amount, fat = :fat, carb = :carb, protein = :protein, calory = :calory, warning_id = :warningId where ingredientId = :ingredientId",
			nativeQuery = true)
	public int update(@Param("ingredientId") String ingredientId, @Param("ingredientType") String ingredientType,
			@Param("unitId") String unitId, @Param("amount") float amount, @Param("fat") float fat,
			@Param("carb") float carb, @Param("protein") float protein, @Param("calory") float calory,
			@Param("warningId") String warningId);

	@Transactional
	@Modifying
	@Query(value = "delete from ingredient where ingredientId = :ingredientId", nativeQuery = true)
	public int delete(@Param("ingredientId") String ingredientId);

}
