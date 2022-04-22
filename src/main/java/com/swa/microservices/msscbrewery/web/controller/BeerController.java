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
	
	@PostMapping
	public ResponseEntity handlePost(@Valid @RequestBody BeerDTO beerDto){
		BeerDTO savedBeer=service.saveNewBeer(beerDto);
		
		HttpHeaders headers=new HttpHeaders();
		
		headers.add("Location", "/api/v1/beer/id="+savedBeer.getId().toString());
		
		return new ResponseEntity(headers,HttpStatus.CREATED);
	}
	
	@PutMapping("/{beerId}")
	public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId,@Valid @RequestBody BeerDTO beerDto) {
		
		service.updateBeer(beerDto,beerId);
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{beerId}")
	//@ResponseStatus(HttpStatus.NO_CONTENT)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public void deleteById(@PathVariable("beerId") UUID beerId) {
		service.deleteById(beerId);
	}
	
	
}
