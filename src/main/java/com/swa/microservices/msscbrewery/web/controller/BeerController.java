package com.swa.microservices.msscbrewery.web.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swa.microservices.msscbrewery.web.model.BeerDTO;
import com.swa.microservices.msscbrewery.web.services.BeerService;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

	
	private final BeerService service;
	
	@Autowired
	public BeerController(BeerService service) {
		super();
		this.service = service;
	}

	
	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDTO> getBeer(@PathVariable("beerId") UUID beerId){
		
		return new ResponseEntity<>(service.getBeerById(beerId),HttpStatus.OK);
	}
	
}
