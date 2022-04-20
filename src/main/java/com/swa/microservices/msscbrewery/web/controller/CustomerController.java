package com.swa.microservices.msscbrewery.web.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
