package com.swa.microservices.msscbrewery.web.services;

import java.util.UUID;

import com.swa.microservices.msscbrewery.web.model.BeerDTO;

public interface BeerService {

	public BeerDTO getBeerById(UUID beerId);
}
