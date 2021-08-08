package com.programming.techie.expensetrackerapi.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseError {

	private String expenseErrorMessage;
	private Integer expenseErrorCode;
}
