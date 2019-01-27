package com.rdanillo.projeto.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableEurekaClient
@ComponentScan(basePackages = "com.rdanillo")
public class RDanilloApplication {

	public static void main(String[] args) {
		SpringApplication.run(RDanilloApplication.class, args);
	}

}

