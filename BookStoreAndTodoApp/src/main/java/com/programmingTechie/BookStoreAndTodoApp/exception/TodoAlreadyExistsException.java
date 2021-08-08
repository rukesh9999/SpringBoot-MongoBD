package com.programmingTechie.BookStoreAndTodoApp.exception;

public class TodoAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TodoAlreadyExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TodoAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public TodoAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public TodoAlreadyExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public TodoAlreadyExistsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
