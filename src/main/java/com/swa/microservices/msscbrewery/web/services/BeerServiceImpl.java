package com.swa.microservices.msscbrewery.web.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.swa.microservices.msscbrewery.web.model.BeerDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

	@Override
	public BeerDTO getBeerById(UUID beerId) {
		
		return BeerDTO.builder().id(UUID.randomUUID())
				.beerName("Galaxy Cat")
				.beerStyle("Pale Ale")
				.build();
	}

	@Override
	public BeerDTO saveNewBeer(BeerDTO beerDto) {
		
		return BeerDTO.builder()
				.id(UUID.randomUUID())
				.build();
	}

	@Override
	public void updateBeer(BeerDTO beerDto, UUID beerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(UUID beerId) {
		log.debug("Beer is being deleted..");
		
	}

}
