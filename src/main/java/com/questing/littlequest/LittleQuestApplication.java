package com.questing.littlequest;

//Springboot MVC libraries for application functionality
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//runs the application itself
@SpringBootApplication
public class LittleQuestApplication {

	public static void main(String[] args) {
		SpringApplication.run(LittleQuestApplication.class, args);

		//handy way to click to see localhost version of application from IDE when working
		System.out.println("http://localhost:8080");
	}
}
