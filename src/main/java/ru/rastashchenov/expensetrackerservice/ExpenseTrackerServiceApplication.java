package ru.rastashchenov.expensetrackerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExpenseTrackerServiceApplication {

	public static void main(String[] args) {
		System.out.println("Hello world");
		SpringApplication.run(ExpenseTrackerServiceApplication.class, args);
	}

}
