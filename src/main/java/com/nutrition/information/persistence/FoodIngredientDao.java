package com.nutrition.information.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nutrition.information.entities.FoodIngredient;
import com.nutrition.information.entities.FoodIngredientId;

@Repository
public interface FoodIngredientDao extends JpaRepository<FoodIngredient,FoodIngredientId> {

	
}
