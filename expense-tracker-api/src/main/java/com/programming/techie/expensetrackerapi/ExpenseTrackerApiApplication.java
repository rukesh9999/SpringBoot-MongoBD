package com.programming.techie.expensetrackerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.programming.techie.expensetrackerapi.config.SwaggerConfig;

@SpringBootApplication
@Import(SwaggerConfig.class)
public class ExpenseTrackerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerApiApplication.class, args);
	}

}
