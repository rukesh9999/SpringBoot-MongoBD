package com.programmingTechie.BookStoreAndTodoApp.service;

import java.util.List;

import com.programmingTechie.BookStoreAndTodoApp.model.TodoDTO;

public interface TodoService {

	 public void createTodo(TodoDTO todoDTO);
	 public List<TodoDTO> getAllTodos();
	 public TodoDTO getTodo(String id);
	 public TodoDTO updateTodo(String id,TodoDTO todoDTO);
	 public void deleteTodoById(String id);
}
