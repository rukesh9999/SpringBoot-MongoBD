package com.programming.techie.expensetrackerapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators.Exp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.programming.techie.expensetrackerapi.dto.ExpenseDTO;
import com.programming.techie.expensetrackerapi.exception.ExpenseAlreadyExistsException;
import com.programming.techie.expensetrackerapi.exception.ExpenseException;
import com.programming.techie.expensetrackerapi.exception.NoSuchExpenseFoundException;
import com.programming.techie.expensetrackerapi.model.Expense;
import com.programming.techie.expensetrackerapi.repository.ExpenseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;
	
	
	public String addExpense(ExpenseDTO expensedto)
	{
		Optional<Expense> optExpense = expenseRepository.findByName(expensedto.getExpenseName());
		if(optExpense.isPresent())
		throw new ExpenseAlreadyExistsException("Expense Already exists");
		Expense expense =   mapFromDto(expensedto);
		
		try {
		 expenseRepository.insert(expense);
		}catch (Exception e) {
			throw new ExpenseException(e.getMessage());
		}
	     return expense.getId();
	}
	
	
	public ExpenseDTO getExpenseByName(String name)
	{
		ExpenseDTO  expenseDTO=null;
		Optional<Expense> optexpense =  expenseRepository.findByName(name);
		if(!optexpense.isPresent())
		throw new NoSuchExpenseFoundException("No such expense found");
		else
		expenseDTO =  mapToDto(optexpense.get());		
		
		return expenseDTO;		
	}
	
	
	public List<ExpenseDTO>  getAllExpenses()
	{
		return expenseRepository.findAll()
				.stream()
				.map(this::mapToDto)
				.collect(Collectors.toList());
	}
	
	public ExpenseDTO updateExpense(ExpenseDTO expenseDTO)
	{
		Optional<Expense> optexpense =  expenseRepository.findById(expenseDTO.getId());
		if(!optexpense.isPresent()) {
		  throw new NoSuchExpenseFoundException("No such expense found to update");
		}
		else {
		 Expense expensesave = optexpense.get();
		 expensesave.setExpenseAmount(expenseDTO.getExpenseAmount());
		 expensesave.setExpenseName(expenseDTO.getExpenseName());
		 expensesave.setExpenseCategory(expenseDTO.getExpenseCategory());
		 expenseRepository.save(expensesave);
		 return mapToDto(expensesave);
		}
		
	}
	
	

	public void deleteExpense(String expenseId) {
		
		Optional<Expense> optexpense = expenseRepository.findById(expenseId);
		if(!optexpense.isPresent())
		throw new NoSuchExpenseFoundException(" No such Expense Found to delete");
		else
		expenseRepository.delete(optexpense.get());
	}
	
	
	public Expense mapFromDto(ExpenseDTO expensedto)
	{
		return Expense.builder()
				.expenseName(expensedto.getExpenseName())
				.expenseCategory(expensedto.getExpenseCategory())
				.expenseAmount(expensedto.getExpenseAmount()).build();
	}
	
	
	public ExpenseDTO mapToDto(Expense expense)
	{
		return ExpenseDTO.builder()
				.expenseName(expense.getExpenseName())				
				.expenseCategory(expense.getExpenseCategory())
				.expenseAmount(expense.getExpenseAmount())
				.id(expense.getId()).build();
	}


}
