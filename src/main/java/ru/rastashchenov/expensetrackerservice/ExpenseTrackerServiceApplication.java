package ru.rastashchenov.expensetrackerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ExpenseTrackerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerServiceApplication.class, args);
	}

}
