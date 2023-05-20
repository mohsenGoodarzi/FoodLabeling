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
import com.nutrition.information.entities.CuisineType;
import com.nutrition.information.persistence.CuisineTypeDao;

@RunWith(SpringRunner.class)
@ImportAutoConfiguration
@SpringBootTest(classes=Application.class)
@TestInstance(Lifecycle.PER_CLASS)
class CuisineTypeDaoTests {

	@Autowired
	private CuisineTypeDao cuisineTypeDao;
	
	@Test
	void aInsertCuisineTypeTest() {
		int rowsAffectedTurkish = cuisineTypeDao.insert("Turkish", "Turkish");
		int rowsAffectedArabic = cuisineTypeDao.insert("Arabic", "Arabic");
		
		assertEquals(1,rowsAffectedTurkish);
		assertEquals(1,rowsAffectedArabic);
	}
	
	@Test
	void bGetCuisineTypeTest() {
	
		CuisineType got = cuisineTypeDao.getCuisineType("Turkish");
		
		CuisineType parent = new CuisineType();
		parent.setCuisineTypeId("Turkish");
		CuisineType expected = new CuisineType("Turkish",parent);
		assertEquals(expected, got);
		
	}
	@Test
	void cGetAllCuisineTypeTest() {
		List<CuisineType> got = cuisineTypeDao.getAllCuisineTypes();
		List <CuisineType> expected = new ArrayList<>();
		
		CuisineType parentArabic = new CuisineType();
		parentArabic.setCuisineTypeId("Arabic");
		CuisineType arabic = new CuisineType("Arabic", parentArabic);
		expected.add(arabic);
		
		CuisineType parentTurkish = new CuisineType();
		parentTurkish.setCuisineTypeId("Turkish");
		CuisineType turkish = new CuisineType("Turkish", parentTurkish);
		expected.add(turkish);
		
		
		
		assertArrayEquals(expected.toArray(), got.toArray());
	}
	
	@Test
	void dUpdateCuisineTypeTest() {
		CuisineType parent = new CuisineType();
		parent.setCuisineTypeId("Arabic");
		int rowsAffected = cuisineTypeDao.update("Turkish", parent);
		assertEquals(1,rowsAffected);
		
	}

	@Test
	void eRemoveCuisineTypeTest() {
		int got = cuisineTypeDao.delete("Turkish");
		assertEquals(1, got);
	}

}
