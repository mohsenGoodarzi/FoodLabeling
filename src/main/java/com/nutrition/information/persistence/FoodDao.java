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
public interface FoodDao extends JpaRepository<Food, String> {

	@Query(value = "from Food")
	public List<Food> getAllFoods();

	@Query(value = "from Food where foodId = :foodId")
	public Food getFood(@Param("foodId") String foodId);

	@Transactional
	@Modifying
	@Query(value = "insert into Food (foodId,dishTypeId,cuisineTypeId,foodType)values(:foodId,:dishTypeId,:cuisineTypeId,:foodType)",
			nativeQuery = true)
	public int insert(@Param("foodId") String foodId, @Param("dishTypeId") String dishTypeId,
			@Param("cuisineTypeId") String cuisineTypeId, @Param("foodType") String foodType);

	@Transactional
	@Modifying
	@Query(value = "update Food set dishTypeId = :dishTypeId, cuisineTypeId = :cuisineTypeId,foodType = :foodType  where foodId = :foodId",
			nativeQuery = true)
	public int update(@Param("foodId") String foodId, @Param("dishTypeId") String dishTypeId,
			@Param("cuisineTypeId") String cuisineTypeId, @Param("foodType") String foodType);

	@Transactional
	@Modifying
	@Query(value = "delete from Food where foodId = :foodId", nativeQuery = true)
	public int delete(@Param("foodId") String foodId);

}
