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
import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nutrition.information.entities.Warning;
import com.nutrition.information.app.Application;
import com.nutrition.information.entities.Ingredient;
import com.nutrition.information.entities.IngredientType;
import com.nutrition.information.entities.Unit;
import com.nutrition.information.persistence.IngredientDao;
import com.nutrition.information.persistence.IngredientTypeDao;
import com.nutrition.information.persistence.UnitDao;
import com.nutrition.information.persistence.WarningDao;

@RunWith(SpringRunner.class)
@ImportAutoConfiguration
@SpringBootTest(classes=Application.class)
@TestInstance(Lifecycle.PER_CLASS)
class IngredientDaoTests {

	@Autowired
	private IngredientDao ingredientDao;
	@Autowired
	private IngredientTypeDao ingredientTypeDao;
	@Autowired
	private UnitDao unitDao; 
	@Autowired
	private WarningDao warningDao;
	
	 @Parameter(0)  
	 private IngredientType ingredientTypeParent;
	 @Parameter(1)  
	 private IngredientType ingredientType;
	 @Parameter(2)
	 private Unit unit;
	 @Parameter(3)
	 Warning warning;
	 @BeforeAll
	void setup() {
		ingredientTypeDao.insert("Beans", "Beans");
		unitDao.insert("cup", 236.588236);
		warningDao.insert("Not Specified","Not Specified", "No Message");
		ingredientTypeParent = new IngredientType();
		ingredientTypeParent.setIngredientTypeId("Beans");
		ingredientType = new IngredientType("Beans",ingredientTypeParent);
		unit = new Unit("cup",236.588236); 
		warning = new Warning("Not Specified","Not Specified", "No Message");
	}
	
	@Test
	void addTest() {

		int rowsAffectedKidnyBeans  = ingredientDao.insert("Kidny beans", "Beans", "cup", 1.5f, 1.0f,16.0f , 8.0f,110.0f,"Not Specified");
		int rowsAffectedWhiteBeans  = ingredientDao.insert("White beans", "Beans", "cup", 1.5f, 0.0f, 17.0f, 6.0f, 90.0f, "Not Specified");
		assertEquals(1, rowsAffectedKidnyBeans);
		assertEquals(1, rowsAffectedWhiteBeans);
		
	}
	@Test
	void getAllTest() {
		
		List<Ingredient> got = ingredientDao.getAllIngredients();
		List<Ingredient> expected = new ArrayList<Ingredient>();
		expected.add(new Ingredient("Kidny beans",ingredientType,unit, 3.0f, 2.0f,32.0f , 16.0f,220.0f, warning));
		expected.add(new Ingredient("White beans",ingredientType,unit, 1.5f, 0.0f, 17.0f, 6.0f, 90.0f, warning));
		assertArrayEquals(expected.toArray(), got.toArray());
	}
	
	@Test
	void getTest() {
		Ingredient expected = new Ingredient("Kidny beans",ingredientType,unit, 3.0f, 2.0f,32.0f , 16.0f,220.0f, warning);
		Ingredient got = ingredientDao.getIngredient("Kidny beans");
		assertEquals(expected, got);
	}
	
	@Test
	void updateTest() {
		int rowAffected = ingredientDao.update("Kidny beans","Beans","cup", 3.0f, 2.0f,32.0f , 16.0f,220.0f, "Not Specified");
		assertEquals(1, rowAffected);
	}

	@Test
	void removeTest() {
		int rowAffectedKidnyBeans = ingredientDao.delete("Kidny beans");
		int rowAffectedWhiteBeans = ingredientDao.delete("White beans");
		assertEquals(1, rowAffectedKidnyBeans);
		assertEquals(1, rowAffectedWhiteBeans);
	}
	
	@AfterAll
	void teardown() {
		ingredientTypeDao.update("Beans",null);
		ingredientTypeDao.delete("Beans");
		unitDao.delete("cup");
		warningDao.delete("Not Specified");
	}

}
