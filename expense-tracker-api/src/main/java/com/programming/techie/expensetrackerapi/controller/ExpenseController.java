package com.programming.techie.expensetrackerapi.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.programming.techie.expensetrackerapi.dto.ExpenseDTO;
import com.programming.techie.expensetrackerapi.service.ExpenseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/expense")
@RequiredArgsConstructor
public class ExpenseController {
   @Autowired
	private ExpenseService expenseService;
	
	@PostMapping
	public   ResponseEntity<?> addExpense(@RequestBody @Valid ExpenseDTO expenseDTO)
	{
		String expenseId =  expenseService.addExpense(expenseDTO);
		 URI location =ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(expenseId)
				.toUri();
		
		 return ResponseEntity.created(location).build();
	}
	
	
	@GetMapping("/{name}")
	public ResponseEntity<ExpenseDTO> getExpense(@PathVariable("name") String expensename)
	{
		 ExpenseDTO expenseDTO =  expenseService.getExpenseByName(expensename);
		 return new ResponseEntity<ExpenseDTO>(expenseDTO,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<ExpenseDTO>> getAllExpenses()
	{
		List<ExpenseDTO> expenses = expenseService.getAllExpenses();
		return new ResponseEntity<List<ExpenseDTO>>(expenses,HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<ExpenseDTO> updateExpense(@RequestBody ExpenseDTO expenseDTO)
	{
		 expenseDTO = expenseService.updateExpense(expenseDTO);
		 return new ResponseEntity<ExpenseDTO>(expenseDTO,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteExpense(@PathVariable("id") String expenseId)
	{
		 expenseService.deleteExpense(expenseId);
		 return new ResponseEntity<String>("expense deleted successfully with id...."+expenseId,HttpStatus.OK);
	}
}
