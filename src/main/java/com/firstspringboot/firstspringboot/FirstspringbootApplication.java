package com.firstspringboot.firstspringboot;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstspringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =SpringApplication.run(FirstspringbootApplication.class, args);

		PojoBean pojoBean = context.getBean(PojoBean.class);
		pojoBean.show();
	}

}
