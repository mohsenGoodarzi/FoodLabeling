package com.nutrition.information.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutrition.information.entities.Food;
import com.nutrition.information.persistence.FoodDao;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodDao foodDao;

	public List<Food> all() {
		return foodDao.getAllFoods();
	}

	public Food getFood(String foodId) {
		return foodDao.getFood(foodId);
	}

	public int add(Food food) throws Exception {

		return foodDao.insert(food.getFoodId(), food.getDishType().getDishTypeId(), food.getCuisineType().getCuisineTypeId(),
				food.getFoodId());
	}

	public int edit(Food food) throws Exception{
		return foodDao.update(food.getFoodId(), food.getDishType().getDishTypeId(), food.getCuisineType().getCuisineTypeId(),
				food.getFoodId());
	}

	public int remove(String foodId) throws Exception {
		return foodDao.delete(foodId);
	}
}
