package com.nutrition.information.Persistence;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nutrition.information.app.Application;
import com.nutrition.information.entities.CuisineType;
import com.nutrition.information.entities.DishType;
import com.nutrition.information.entities.Food;
import com.nutrition.information.persistence.CuisineTypeDao;
import com.nutrition.information.persistence.DishTypeDao;
import com.nutrition.information.persistence.FoodDao;
@RunWith(SpringRunner.class)
@ImportAutoConfiguration
@SpringBootTest(classes=Application.class)
@TestInstance(Lifecycle.PER_CLASS)
class FoodDaoTests {

	@Autowired
	private FoodDao foodDao;
	@Autowired
	private DishTypeDao dishTypeDao;
	@Autowired
	private CuisineTypeDao cuisineTypeDao;
	
	@BeforeAll
	void setup() {
		dishTypeDao.insert("Main", "Main");
		dishTypeDao.insert("Side Dish", "Side Dish");
		cuisineTypeDao.insert("British", "British");
		cuisineTypeDao.insert("French", "French");
	}
	
	@Test
	void addTest() {
		int effectedRows = foodDao.insert("Fish and chips", "Main","British", "Carnivore");
		assertEquals(1, effectedRows);
	}
	@Test
	void updateTest() {
		int effectedRows = foodDao.update("Fish and chips", "Side Dish", "French", "Not Specified");
		assertEquals(1, effectedRows);
	}
	@Test
	void getTest() {
		DishType dishTypeParent = new DishType();
		dishTypeParent.setDishTypeId("Side Dish");
		CuisineType cuisineTypeParent = new CuisineType();
		cuisineTypeParent.setCuisineTypeId("French");
		Food expected = new Food("Fish and chips", new DishType("Side Dish",dishTypeParent) , new CuisineType("French",cuisineTypeParent) , "Not Specified");
		Food got = foodDao.getFood("Fish and chips");
		assertEquals(expected, got);
	}
	@Test
	void getAllTest() {
		DishType dishTypeParent = new DishType();
		dishTypeParent.setDishTypeId("Side Dish");
		CuisineType cuisineTypeParent = new CuisineType();
		cuisineTypeParent.setCuisineTypeId("French");
		Food expected = new Food("Fish and chips", new DishType("Side Dish",dishTypeParent) , new CuisineType("French",cuisineTypeParent) , "Not Specified");
		List<Food>foods = new ArrayList<Food>();
		foods.add(expected);
		
		List<Food> got = foodDao.getAllFoods();
		assertArrayEquals(foods.toArray(), got.toArray());
	}
	@Test
	void removeTest() {
		int result = foodDao.delete("Fish and chips");
		assertEquals(1, result);
	}
	@AfterAll
	void teardown() {
		dishTypeDao.update("Main", null);
		dishTypeDao.delete("Main");
		dishTypeDao.update("Side Dish", null);
		dishTypeDao.delete( "Side Dish");
		cuisineTypeDao.update("British", null);
		cuisineTypeDao.delete("British");
		cuisineTypeDao.update("French", null);
		cuisineTypeDao.delete("French");
	}

}
