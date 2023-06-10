package com.nutrition.information.Persistence;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nutrition.information.app.Application;
import com.nutrition.information.entities.IngredientType;
import com.nutrition.information.persistence.IngredientTypeDao;
@RunWith(SpringRunner.class)
@ImportAutoConfiguration
@SpringBootTest(classes=Application.class)
@TestInstance(Lifecycle.PER_CLASS)
class IngredientTypeDaoTests {

	@Autowired
	private IngredientTypeDao ingredientTypeDao;
	
	@Test
	void addTest() {
		//IngredientType beans = new IngredientType();
		//beans.setIngredientTypeId("Beans");
		int rowsAffectedBeans = ingredientTypeDao.insert("Beans", "Beans");
		
		int rowsAffectedRedMeat = ingredientTypeDao.insert("Red Meat", "Red Meat");
		
		assertEquals(1,rowsAffectedBeans);
		assertEquals(1,rowsAffectedRedMeat);
	}
	
	@Test
	void getTest() {
	
		IngredientType got = ingredientTypeDao.getIngredientType("Beans");
		IngredientType parent = new IngredientType();
		parent.setIngredientTypeId("Red Meat");
		IngredientType expected = new IngredientType("Beans",parent);
		assertEquals(expected, got, "Expected is not same is got");
		
	}
	@Test
	void getAllTest() {
		List<IngredientType> got = ingredientTypeDao.getAllIngredientTypes();
		List <IngredientType> expected = new ArrayList<>();
		
		IngredientType parentBeans = new IngredientType();
		parentBeans.setIngredientTypeId("Red Meat");
		IngredientType beans = new IngredientType("Beans", parentBeans);
		expected.add(beans);
		
		IngredientType parentRedMeat = new IngredientType();
		parentRedMeat.setIngredientTypeId("Red Meat");
		IngredientType redMeat = new IngredientType("Red Meat", parentRedMeat);
		expected.add(redMeat);
		
		assertArrayEquals(expected.toArray(), got.toArray());
	}
	
	@Test
	void updateTest() {
		IngredientType parent = new IngredientType();
		parent.setIngredientTypeId("Red Meat");
		int rowsAffected = ingredientTypeDao.update("Beans", parent);
		assertEquals(1,rowsAffected);
		
	}

	@Test
	void removeTest() {
		int removeMain = ingredientTypeDao.delete("Beans");
		ingredientTypeDao.update("Red Meat", null);
		int removeSalad = ingredientTypeDao.delete("Red Meat");
		assertEquals(1, removeMain);
		assertEquals(1, removeSalad);
	}

}
