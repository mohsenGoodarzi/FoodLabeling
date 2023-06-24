package com.nutrition.information.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import com.nutrition.information.app.Application;
import com.nutrition.information.entities.CuisineType;
import com.nutrition.information.persistence.CuisineTypeDao;

@ExtendWith(MockitoExtension.class)
@ImportAutoConfiguration
@SpringBootTest(classes = Application.class)
@TestInstance(Lifecycle.PER_CLASS)
public class CuisineServiceTests {

	private final int One_ROW_AFFECTED = 1;

	@Mock
	private CuisineTypeDao cuisineTypeDao;

	@Autowired
	private CuisineTypeService cuisineTypeService;

	@Test
	void addTest() throws Exception {
		CuisineType turkishParent = new CuisineType();
		turkishParent.setCuisineTypeId("Turkish");
		int turkish = cuisineTypeService.add(new CuisineType("Turkish", turkishParent));
		CuisineType arabicParent = new CuisineType();
		arabicParent.setCuisineTypeId("Arabic");
		int arabic = cuisineTypeService.add(new CuisineType("Arabic", arabicParent));
		assertEquals(One_ROW_AFFECTED, turkish);
		assertEquals(One_ROW_AFFECTED, arabic);
	}

	@Test
	void getTest() throws Exception {
		CuisineType expectedParent = new CuisineType();
		expectedParent.setCuisineTypeId("Arabic");
		CuisineType expected = new CuisineType("Arabic", expectedParent);
		CuisineType got = cuisineTypeService.getCuisineType("Arabic");
		assertEquals(expected, got);
	}

	@Test
	void getAllTest() throws Exception {
		List<CuisineType> expected = new ArrayList<CuisineType>();

		CuisineType arabicParent = new CuisineType();
		arabicParent.setCuisineTypeId("Arabic");
		expected.add(new CuisineType("Arabic", arabicParent));

		CuisineType turkishParent = new CuisineType();
		turkishParent.setCuisineTypeId("Turkish");
		expected.add(new CuisineType("Turkish", turkishParent));

		List<CuisineType> gotAll = cuisineTypeService.getAllCuisineTypes();

		assertEquals(expected, gotAll);
	}

	@Test
	void editTest() throws Exception {

		CuisineType turkishParent = new CuisineType();
		turkishParent.setCuisineTypeId("Arabic");
		int turkish = cuisineTypeService.edit(new CuisineType("Turkish", turkishParent));
		assertEquals(One_ROW_AFFECTED, turkish);

	}

	@Test
	void deleteTest() throws Exception {

		CuisineType turkish = new CuisineType("Turkish", null);
		cuisineTypeService.edit(turkish);
		CuisineType arabic = new CuisineType("Arabic", null);
		cuisineTypeService.edit(arabic);
		int resultTurkish = cuisineTypeService.remove("Turkish");
		int resultArabic = cuisineTypeService.remove("Arabic");
		assertEquals(1, resultTurkish);
		assertEquals(1, resultArabic);
	}

}
