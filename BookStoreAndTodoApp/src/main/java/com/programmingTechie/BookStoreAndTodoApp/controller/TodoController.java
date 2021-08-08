package com.programmingTechie.BookStoreAndTodoApp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programmingTechie.BookStoreAndTodoApp.model.TodoDTO;
import com.programmingTechie.BookStoreAndTodoApp.service.TodoService;

@RestController
@RequestMapping("/todo")
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@PostMapping("/save")
	public ResponseEntity<TodoDTO> save(@RequestBody TodoDTO todoDTO) {			
		todoService.createTodo(todoDTO);				
		return new ResponseEntity<TodoDTO>(todoDTO,HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/getTodos")
	public ResponseEntity<?> getTodos()
	{
		List<TodoDTO> todos = todoService.getAllTodos();		
		return new ResponseEntity<>(todos,todos.size()>0?HttpStatus.OK:HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping("/gettodo/{id}")
	public ResponseEntity<TodoDTO> getTodo(@PathVariable String id)
	{
		TodoDTO todo = todoService.getTodo(id);		
		return new ResponseEntity<TodoDTO>(todo,HttpStatus.OK);
	}
	
	
	@PutMapping("/updatetodo/{id}")
	public ResponseEntity<TodoDTO> getTodo(@PathVariable String id,@RequestBody TodoDTO todoDto)
	{		
		TodoDTO todo = todoService.updateTodo(id, todoDto);		
		return new ResponseEntity<TodoDTO>(todo,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deletetodo/{id}")
	public ResponseEntity<?> deleteTodo(@PathVariable String id)
	{
		 todoService.deleteTodoById(id);				
		 return new ResponseEntity<>("ToDo with id... "+id+"... deleted successfully",HttpStatus.OK);
	}
}
