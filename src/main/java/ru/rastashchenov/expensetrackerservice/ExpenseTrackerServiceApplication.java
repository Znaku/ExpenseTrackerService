package ru.rastashchenov.expensetrackerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients
@EnableReactiveCassandraRepositories
@EnableScheduling
public class ExpenseTrackerServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerServiceApplication.class, args);
	}
}
