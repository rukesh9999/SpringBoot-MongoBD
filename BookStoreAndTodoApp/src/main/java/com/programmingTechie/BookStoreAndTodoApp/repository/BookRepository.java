package com.programmingTechie.BookStoreAndTodoApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.programmingTechie.BookStoreAndTodoApp.model.Book;
@Repository
public interface BookRepository extends MongoRepository<Book, Integer>{

}
