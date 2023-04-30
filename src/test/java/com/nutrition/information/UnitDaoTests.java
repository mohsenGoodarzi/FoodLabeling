package com.nutrition.information;

import static org.junit.jupiter.api.Assertions.*;

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
		unitDao.insert("Test Unit", 1.3);
	}
	
	@Test
	void remove() {
		
		unitDao.delete("Test Unit");
		Unit unit = unitDao.getUnit("Test Unit");
		assertEquals(null, unit);
	}

}
