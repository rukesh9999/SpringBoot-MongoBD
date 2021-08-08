package com.programming.techie.expensetrackerapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler(NoSuchExpenseFoundException.class)
	public ResponseEntity<ExpenseError> handleNoSuchExpenseFoundException(NoSuchExpenseFoundException nsefe)
	{
		ExpenseError expenseError = new ExpenseError(nsefe.getMessage(),HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ExpenseError>(expenseError,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(ExpenseException.class)
	public ResponseEntity<ExpenseError> handleExpenseException(ExpenseException ee)
	{
		ExpenseError expenseError = new ExpenseError(ee.getMessage(),HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<ExpenseError>(expenseError,HttpStatus.NOT_FOUND);		
	}
	
	
	
	@ExceptionHandler(ExpenseAlreadyExistsException.class)
	public ResponseEntity<ExpenseError> handleExpenseAlreadyExistsException(ExpenseAlreadyExistsException ee)
	{
		ExpenseError expenseError = new ExpenseError(ee.getMessage(),HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<ExpenseError>(expenseError,HttpStatus.NOT_FOUND);		
	}
	
}
