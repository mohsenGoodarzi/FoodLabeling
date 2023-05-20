package com.nutrition.information.services;

import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import com.nutrition.information.app.Application;
import com.nutrition.information.entities.Unit;
import com.nutrition.information.persistence.UnitDao;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@ImportAutoConfiguration
@SpringBootTest(classes = Application.class)
class UnitServiceTests {
	private final int One_ROW_AFFECTED = 1;
	@Mock
	private UnitDao unitDao;
	@Autowired
	private UnitService unitService;

	@Test
	void addUnit() throws Exception {
		int unitOne = unitService.add(new Unit("Unit 1", 2.1));
		int unitTwo = unitService.add(new Unit("Unit 2", 2.2));
		assertEquals(One_ROW_AFFECTED, unitOne);
		assertEquals(One_ROW_AFFECTED, unitTwo);
	}

	@Test
	void getUnit() throws Exception {
		Unit expected = new Unit("Unit 1", 2.1);
		Unit got = unitService.getUnit("Unit 1");

		assertEquals(expected, got);

	}

	@Test
	void getAllUnit() throws Exception {
		List<Unit> expected = new ArrayList<Unit>();

		expected.add(new Unit("Unit 1", 2.1));
		expected.add(new Unit("Unit 2", 2.2));

		List<Unit> gotAll = unitService.getAllUnits();

		assertEquals(expected, gotAll);
	}

	@Test
	void editUnit() throws Exception {

		int unitThree = unitService.edit(new Unit("Unit 2", 2.3));
		assertEquals(One_ROW_AFFECTED, unitThree);

	}

	@Test
	void deleteUnit() throws Exception {
		int resultUnitOne = unitService.remove("Unit 1");
		int resdultUnitTwo = unitService.remove("Unit 2");
		assertEquals(One_ROW_AFFECTED, resultUnitOne);
		assertEquals(One_ROW_AFFECTED, resdultUnitTwo);
	}
}
