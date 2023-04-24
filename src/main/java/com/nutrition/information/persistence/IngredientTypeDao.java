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

	@Query("from IngredientType")
	public List<IngredientType> getAllIngredientTypes();
	
	@Query("from IngredientType where ingredientTypeId = :ingredientTypeId")
	public IngredientType getIngredientType(@Param("ingredientTypeId") String ingredientTypeId);
	
	@Transactional
	@Modifying
	@Query(value = "insert into IngredientType (ingredientTypeId,member)values(:ingredientTypeId,:member)",nativeQuery = true)
	public int create(@Param("ingredientTypeId")String ingredientTypeId, @Param("member")String member);
	
	@Transactional
	@Modifying
	@Query(value="Update IngredientType set member = :member where ingredientTypeId = :ingredientTypeId", nativeQuery = true)
	public int update(@Param("ingredientTypeId") String cuisineTypeId,@Param("member") String member);  
	
	@Transactional
	@Modifying
	@Query(value = "delete from IngredientType where ingredientTypeId = :ingredientTypeId", nativeQuery = true)
	public int delete(@Param("ingredientTypeId") String ingredientTypeId);
}
