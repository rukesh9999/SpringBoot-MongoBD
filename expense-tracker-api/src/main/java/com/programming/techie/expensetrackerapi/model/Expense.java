package com.programming.techie.expensetrackerapi.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Document(collection="Expensetracker")
public class Expense {
    @Id
	private String id;
    @Field(name = "name")
    @Indexed(unique=true)
    @NotNull(message = "Name is required")
	private String expenseName;
    @Field(name = "category")
    @NotNull(message = "category is required")
	private ExpenseCategory expenseCategory;
    @Field(name = "amount")
    @NotNull(message = "amount is required")
	private BigDecimal expenseAmount;
	
}
