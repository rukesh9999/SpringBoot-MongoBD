package com.programmingTechie.BookStoreAndTodoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.programmingTechie.BookStoreAndTodoApp.config.SwaggerConfig;

@SpringBootApplication
@Import(SwaggerConfig.class)
public class BookStoreAndTodoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreAndTodoAppApplication.class, args);
	}

}
