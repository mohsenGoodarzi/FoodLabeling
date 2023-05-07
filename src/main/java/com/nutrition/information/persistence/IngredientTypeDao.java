package com.nutrition.information.persistence;


import java.util.List;

import org.springframework.data.annotation.Persistent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.nutrition.information.entities.IngredientType;

@Persistent
public interface IngredientTypeDao extends JpaRepository<IngredientType, String> {

	@Query(value="from ingredient_type", nativeQuery = true )
	public List<IngredientType> getAllIngredientTypes();
	
	@Query(value="from ingredient_type where ingredient_type_id = :ingredientTypeId", nativeQuery = true)
	public IngredientType getIngredientType(@Param("ingredientTypeId") String ingredientTypeId);
	
	@Transactional
	@Modifying
	@Query(value = "insert into ingredient_type (ingredient_type_id,member)values(:ingredientTypeId,:member)",nativeQuery = true)
	public int create(@Param("ingredientTypeId")String ingredientTypeId, @Param("member")String member);
	
	@Transactional
	@Modifying
	@Query(value="Update ingredient_type set member = :member where ingredient_type_id = :ingredientTypeId", nativeQuery = true)
	public int update(@Param("ingredientTypeId") String cuisineTypeId,@Param("member") String member);  
	
	@Transactional
	@Modifying
	@Query(value = "delete from ingredient_type where ingredient_type_id = :ingredientTypeId", nativeQuery = true)
	public int delete(@Param("ingredientTypeId") String ingredientTypeId);
}
