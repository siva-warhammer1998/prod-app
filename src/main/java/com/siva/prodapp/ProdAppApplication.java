package com.siva.prodapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.siva.prodapp")
public class ProdAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProdAppApplication.class, args);
	}

}
