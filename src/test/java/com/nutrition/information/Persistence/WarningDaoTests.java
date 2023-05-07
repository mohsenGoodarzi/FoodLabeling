package com.nutrition.information.Persistence;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nutrition.information.app.Application;

@RunWith(SpringRunner.class)
@ImportAutoConfiguration
@SpringBootTest(classes=Application.class)
class WarningDaoTests {

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
