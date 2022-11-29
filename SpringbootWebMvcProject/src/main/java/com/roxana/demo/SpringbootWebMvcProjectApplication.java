package com.roxana.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.roxana")
public class SpringbootWebMvcProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebMvcProjectApplication.class, args);
	}

}
