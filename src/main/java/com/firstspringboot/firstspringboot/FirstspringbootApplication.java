package com.firstspringboot.firstspringboot;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.ConfigurableApplicationContext;
import com.firstspringboot.firstspringboot.service.DatabaseService;

import com.firstspringboot.firstspringboot.resourcehandson.ResourcesInjectMain;
import com.firstspringboot.firstspringboot.service.GetFactorial;

@SpringBootApplication
public class FirstspringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FirstspringbootApplication.class, args);

		// PojoBean pojoBean = context.getBean(PojoBean.class);
		// pojoBean.show();

		// ResourcesInjectMain resourcesInjectMain =
		// context.getBean(ResourcesInjectMain.class);
		// System.out.println(resourcesInjectMain);

		// GetFactorial getFactorial = context.getBean(GetFactorial.class);
		// System.out.println("Getting Factorial of 5 using Service bean: " +
		// getFactorial.find(5));

		DatabaseService databaseService = context.getBean(DatabaseService.class);
		System.out.println(databaseService);

	}

}
