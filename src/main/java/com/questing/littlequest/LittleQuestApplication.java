package com.questing.littlequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LittleQuestApplication {

	public static void main(String[] args) {
		SpringApplication.run(LittleQuestApplication.class, args);
		System.out.println("http://localhost:8080");
	}
}
