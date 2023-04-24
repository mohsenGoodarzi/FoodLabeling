package com.nutrition.information.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication(scanBasePackages ="com.nutrition.information")
@EntityScan(basePackages = "com.nutrition.information.entities")
@EnableJpaRepositories(basePackages = "com.nutrition.information.persistence")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
