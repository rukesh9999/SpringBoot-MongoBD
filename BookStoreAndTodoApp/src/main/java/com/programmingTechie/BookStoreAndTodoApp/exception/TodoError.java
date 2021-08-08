package com.programmingTechie.BookStoreAndTodoApp.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoError {

	private String errorMessage;
	private Integer errorCode;
}
