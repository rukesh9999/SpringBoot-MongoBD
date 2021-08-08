package com.programming.techie.expensetrackerapi.dto;

import java.math.BigDecimal;

import com.programming.techie.expensetrackerapi.model.ExpenseCategory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseDTO {

	private String id;
	private String expenseName;
	private ExpenseCategory expenseCategory;
	private BigDecimal expenseAmount;
	
}
