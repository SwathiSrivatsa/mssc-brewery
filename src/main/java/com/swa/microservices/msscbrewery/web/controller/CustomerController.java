package com.swa.microservices.msscbrewery.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.swa.microservices.msscbrewery.web.model.CustomerDTO;
import com.swa.microservices.msscbrewery.web.services.CustomerService;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
	
	private final CustomerService service;
	
	@Autowired
	public CustomerController(CustomerService service) {
		super();
		this.service = service;
	}

	@GetMapping("/{custId}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("custId") UUID custId){
		
		return new ResponseEntity<CustomerDTO>(service.getCustomerById(custId),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity handleCustomer(@Valid @RequestBody CustomerDTO custDto) {
		
		CustomerDTO savedDto=service.createNewCustomer(custDto);
		
		HttpHeaders header=new HttpHeaders();
		header.add("Location", "/api/v1/customer"+savedDto.getCustomerId().toString());
		
		return new ResponseEntity(header,HttpStatus.CREATED);
	}
	
	@PutMapping("/{custId}")
	public ResponseEntity handleUpdate(@PathVariable("custId") UUID custId, 
			@Valid @RequestBody CustomerDTO custDto) {
		
		service.updateById(custDto,custId);
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{custId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable("custId") UUID custId) {
		
		service.deleteById(custId);
	}
	
	/*
	 * @ExceptionHandler(ConstraintViolationException.class) public
	 * ResponseEntity<List> validationErrorHandler(ConstraintViolationException e){
	 * 
	 * List<String> errors=new ArrayList<>(e.getConstraintViolations().size());
	 * 
	 * e.getConstraintViolations().forEach(constrainViolation -> {
	 * errors.add(constrainViolation.getPropertyPath() + ":" +
	 * constrainViolation.getMessage()); });
	 * 
	 * return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST); }
	 */

}
