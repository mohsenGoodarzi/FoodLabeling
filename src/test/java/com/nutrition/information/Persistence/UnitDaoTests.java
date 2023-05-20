package com.nutrition.information.Persistence;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nutrition.information.app.Application;
import com.nutrition.information.entities.Unit;
import com.nutrition.information.persistence.UnitDao;

@RunWith(SpringRunner.class)
@ImportAutoConfiguration
@SpringBootTest(classes=Application.class)
class UnitDaoTests {

	@Autowired
	private UnitDao unitDao;
	
	@Test
	void aInsert() {
		int unitOne = unitDao.insert("Test Unit 1", 1.3);
		int unitTwo = unitDao.insert("Test Unit 2", 1.4);
		assertEquals(1, unitOne);
		assertEquals(1, unitTwo);
	}
	@Test
	void bGetAllUnitsTest() {
		List<Unit> got = unitDao.getAllUnits();
		List<Unit> expected = new ArrayList<Unit>();
		expected.add(new Unit("Test Unit 1",1.3));
		expected.add(new Unit("Test Unit 2", 1.4));
		assertArrayEquals(expected.toArray(), got.toArray());
	}
	
	@Test
	void cGetUnitTest() {
		Unit got = unitDao.getUnit("Test Unit 1");
		Unit expected = new Unit("Test Unit 1",1.3);
		assertEquals(expected, got );
	}
	
	@Test
	void dUpdateTest() {
		Unit expected = new Unit("Test Unit 1",1.5);
		unitDao.update("Test Unit 1",1.5);
		Unit unit = unitDao.getUnit("Test Unit 1");
		assertEquals(expected, unit);
	}

	@Test
	void eRemoveTest() {
		unitDao.delete("Test Unit 2");
		Unit unit = unitDao.getUnit("Test Unit 2");
		assertEquals(null, unit);
	}

}
