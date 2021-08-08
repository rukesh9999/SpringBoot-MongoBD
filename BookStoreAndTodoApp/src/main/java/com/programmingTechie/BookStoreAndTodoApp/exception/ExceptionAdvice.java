package com.programmingTechie.BookStoreAndTodoApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
	
	@ExceptionHandler(NoSuchBookFoundException.class)	
	public ResponseEntity<BookError> mapException(NoSuchBookFoundException asbe)
	{
		BookError bookerror =new BookError(HttpStatus.INTERNAL_SERVER_ERROR.value(), asbe.getMessage());
		return new ResponseEntity<BookError>(bookerror,HttpStatus.INTERNAL_SERVER_ERROR);
	  
	}
	
	@ExceptionHandler(NoSuchTodoFoundException.class)
	public ResponseEntity<TodoError> handleNoSuchTodoFoundException(NoSuchTodoFoundException ntf)
	{
		TodoError bookerror = new TodoError(ntf.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<TodoError>(bookerror,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(TodoAlreadyExistsException.class)
	public ResponseEntity<TodoError> handleTodoAlreadyExistsException(TodoAlreadyExistsException ntf)
	{
		TodoError bookerror = new TodoError(ntf.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<TodoError>(bookerror,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(TodoCollectionException.class)
	public ResponseEntity<TodoError> handleTodoCollectionException(TodoCollectionException ntf)
	{
		TodoError bookerror = new TodoError(ntf.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<TodoError>(bookerror,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
