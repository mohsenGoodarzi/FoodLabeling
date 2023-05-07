package com.nutrition.information.Persistence;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
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
	
	@BeforeEach
	void setup() {
		unitDao.insert("Test Unit 1", 1.3);
		unitDao.insert("Test Unit 2", 1.4);
		
	}
	@Test
	void getAllUnitsTest() {
		List<Unit> got = unitDao.getAllUnits();
		List<Unit> expected = new ArrayList<Unit>();
		expected.add(new Unit("Test Unit 1",1.3));
		expected.add(new Unit("Test Unit 2", 1.4));
		assertArrayEquals(expected.toArray(), got.toArray());
	}
	
	@Test
	void getUnitTest() {
		Unit got = unitDao.getUnit("Test Unit 1");
		Unit expected = new Unit("Test Unit 1",1.3);
		assertEquals(expected, got);
	}
	
	
	@Test
	void remove() {
		
		unitDao.delete("Test Unit");
		Unit unit = unitDao.getUnit("Test Unit");
		assertEquals(null, unit);
	}

}
