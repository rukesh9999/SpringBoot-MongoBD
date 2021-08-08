package com.programmingTechie.BookStoreAndTodoApp.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Book")
public class Book {
	private Integer id;
	private String bookName;
	private String authorName;
	
}
