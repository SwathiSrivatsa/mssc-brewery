package com.swa.microservices.msscbrewery.web.services;

import java.util.UUID;

import com.swa.microservices.msscbrewery.web.model.BeerDTO;

public class BeerServiceImpl implements BeerService {

	@Override
	public BeerDTO getBeerById(UUID beerId) {
		
		return BeerDTO.builder().id(UUID.randomUUID())
				.beerName("Galaxy Cat")
				.beerStyle("Pale Ale")
				.build();
	}

}
