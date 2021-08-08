package com.programmingTechie.BookStoreAndTodoApp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programmingTechie.BookStoreAndTodoApp.exception.NoSuchTodoFoundException;
import com.programmingTechie.BookStoreAndTodoApp.exception.TodoAlreadyExistsException;
import com.programmingTechie.BookStoreAndTodoApp.exception.TodoCollectionException;
import com.programmingTechie.BookStoreAndTodoApp.model.TodoDTO;
import com.programmingTechie.BookStoreAndTodoApp.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService{

	@Autowired
	private TodoRepository todoRepository;
	
	@Override
	public void createTodo(TodoDTO todoDTO) {
		
	   Optional<TodoDTO> opttodo = todoRepository.findByTodo(todoDTO.getTodo());
	   if(opttodo.isPresent()) {
	   throw new TodoAlreadyExistsException("Todo Alreadyexists");
	   }else {
		   todoDTO.setCreatedAt(new Date(System.currentTimeMillis()));
		   try {
		   todoRepository.save(todoDTO);
		   }catch (Exception e) {
			 throw new TodoCollectionException(e.getMessage());
		}
	   }
	  
	}

	@Override
	public List<TodoDTO> getAllTodos() {
		
		List<TodoDTO> todos = todoRepository.findAll();		
		if(todos.size()>0) 
		return todos;		
		else 
		return new ArrayList<TodoDTO>();
		
	}
	

	@Override
	public TodoDTO getTodo(String id) {
		Optional<TodoDTO> todo = todoRepository.findById(id);
		
		if(!todo.isPresent())
		throw new TodoCollectionException("No such todo found");
		else 
		return todo.get();
		
	}

	@Override
	public TodoDTO updateTodo(String id, TodoDTO todoDTO) {
		TodoDTO todoSave=null;
		Optional<TodoDTO> todo = todoRepository.findById(id);
		Optional<TodoDTO> todobyName = todoRepository.findByTodo(todoDTO.getTodo());
		if(!todo.isPresent()) {
		 throw new NoSuchTodoFoundException("No such todo found to update");
		}
		else
		{   
			if(todobyName.isPresent()&&!todobyName.get().getId().equals(id))
			throw new TodoAlreadyExistsException("Todo Already exists");
			
			todoSave = todo.get();
			todoSave.setCompleted(todoDTO.getCompleted());
			todoSave.setDescription(todoDTO.getDescription());
			todoSave.setUpdatedAt(new Date(System.currentTimeMillis()));	
			try {
			todoRepository.save(todoSave);
			}catch (Exception e) {
				throw new TodoCollectionException(e.getMessage());
			}
			return todoSave;
		}
				
	}

	@Override
	public void deleteTodoById(String id) {
		Optional<TodoDTO> todos = todoRepository.findById(id);
		if(!todos.isPresent())
		throw new NoSuchTodoFoundException("No such todo found to delete ");
		else
		todoRepository.deleteById(id);	
		
	}
	

}
