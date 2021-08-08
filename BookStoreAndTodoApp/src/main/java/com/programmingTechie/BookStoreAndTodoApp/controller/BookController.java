package com.programmingTechie.BookStoreAndTodoApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programmingTechie.BookStoreAndTodoApp.exception.NoSuchBookFoundException;
import com.programmingTechie.BookStoreAndTodoApp.model.Book;
import com.programmingTechie.BookStoreAndTodoApp.repository.BookRepository;

@RestController
@RequestMapping("/book")
public class BookController {
    
	 @Autowired
	 private BookRepository bookRepository;
	 
	 @PostMapping("/savebook")	
	 public String save(@RequestBody Book book)
	 {
		 bookRepository.save(book);
		 return "Added Book with.."+book.getId();
	 }
	 
	 @GetMapping("/getbooks")
	 public List<Book> getAllBooks()
	 {
		 return bookRepository.findAll();
	 }
	 
	 @GetMapping("/getBook/{id}")
	 public Optional<Book> getBook(@PathVariable("id") int id)
	 {
		 Optional<Book> book = bookRepository.findById(id);
		 if(!book.isPresent())
		 throw new NoSuchBookFoundException("No such book found");
		 
		 return  book;
		 
		  
		  
		 
	 }
	 
	 @DeleteMapping("/deletebook/{id}")
	 public String deleteBook(@PathVariable int id)
	 {
		  String message="Book Deleted Successfully with Id..."+ id;
		  Optional<Book> book= getBook(id);
		  if(!book.isPresent())
		  bookRepository.deleteById(id);
		  else
		  throw new NoSuchBookFoundException("No Such Book Found to delete ") ;
			  
		  return message;
	 }
}
