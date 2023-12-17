package com.example.springbootcorsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SpringBootCorsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCorsDemoApplication.class, args);
	}

}
