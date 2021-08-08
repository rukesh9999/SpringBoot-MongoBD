package com.programmingTechie.BookStoreAndTodoApp.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookError {

	private int errorCode;
	private String errorMessage;
}
