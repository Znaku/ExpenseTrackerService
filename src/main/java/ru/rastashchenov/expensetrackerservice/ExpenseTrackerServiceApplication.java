package ru.rastashchenov.expensetrackerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import ru.rastashchenov.expensetrackerservice.domain.dbone.Limit;


import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ExpenseTrackerServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerServiceApplication.class, args);
	}

}
