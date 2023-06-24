package com.nutrition.information.services;

import java.util.List;

import com.nutrition.information.entities.Food;

public interface FoodService {

	public List<Food> all();

	public Food getFood(String foodId);

	public int add(Food food) throws Exception;

	public int edit(Food food) throws Exception;

	public int remove(String foodId) throws Exception;

}
