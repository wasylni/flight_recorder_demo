package com.sample.demo.memoryleakingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MemoryLeakingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemoryLeakingAppApplication.class, args);
	}

}



