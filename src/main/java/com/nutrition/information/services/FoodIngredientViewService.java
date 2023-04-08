package com.nutrition.information.services;

import java.util.List;

import com.nutrition.information.entities.FoodIngredientView;


public interface FoodIngredientViewService {
	public List<FoodIngredientView> getAllFoodsIngredients();
	public List<FoodIngredientView> getFoodIngredirnts(String foodId);
	
}
