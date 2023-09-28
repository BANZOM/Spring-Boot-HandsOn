package com.firstspringboot.firstspringboot;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.ConfigurableApplicationContext;

import com.firstspringboot.firstspringboot.resourcehandson.ResourcesInjectMain;

@SpringBootApplication
public class FirstspringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =SpringApplication.run(FirstspringbootApplication.class, args);

		PojoBean pojoBean = context.getBean(PojoBean.class);
		pojoBean.show();

		ResourcesInjectMain resourcesInjectMain = context.getBean(ResourcesInjectMain.class);
		System.out.println(resourcesInjectMain);
	}

}
