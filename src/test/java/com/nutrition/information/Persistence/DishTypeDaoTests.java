package com.nutrition.information.Persistence;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
import com.nutrition.information.entities.DishType;
import com.nutrition.information.persistence.DishTypeDao;

@RunWith(SpringRunner.class)
@ImportAutoConfiguration
@SpringBootTest(classes=Application.class)
@TestInstance(Lifecycle.PER_CLASS)
class DishTypeDaoTests {

	@Autowired
	private DishTypeDao dishTypeDao;
	
	@Test
	void addTest() {
		
		int rowsAffectedMain = dishTypeDao.insert("Main", "Main");
		
		int rowsAffectedSalad = dishTypeDao.insert("Salad", "Salad");
		
		assertEquals(1,rowsAffectedMain);
		assertEquals(1,rowsAffectedSalad);
	}
	
	@Test
	void getTest() {
	
		DishType got = dishTypeDao.getDishType("Main");
		DishType parent = new DishType();
		parent.setDishTypeId("Salad");
		DishType expected = new DishType("Main",parent);
		assertEquals(expected, got, "Expected is not same is got");
		
	}
	@Test
	void getAllTest() {
		List<DishType> got = dishTypeDao.getAllDishTypes();
		List <DishType> expected = new ArrayList<>();
		
		DishType parentMain = new DishType();
		parentMain.setDishTypeId("Salad");
		DishType main = new DishType("Main", parentMain);
		expected.add(main);
		
		DishType parentSalad = new DishType();
		parentSalad.setDishTypeId("Salad");
		DishType salad = new DishType("Salad", parentSalad);
		expected.add(salad);
		
		assertArrayEquals(expected.toArray(), got.toArray());
	}
	
	@Test
	void updateTest() {
		
		int rowsAffected = dishTypeDao.update("Main", "Salad");
		assertEquals(1,rowsAffected);
		
	}

	@Test
	void removeTest() {
		int removeMain = dishTypeDao.delete("Main");
		dishTypeDao.update("Salad", null);
		int removeSalad = dishTypeDao.delete("Salad");
		assertEquals(1, removeMain);
		assertEquals(1, removeSalad);
	}

}
