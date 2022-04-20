package com.swa.microservices.msscbrewery.web.services;

import java.util.UUID;

import com.swa.microservices.msscbrewery.web.model.CustomerDTO;

public interface CustomerService {

	CustomerDTO getCustomerById(UUID custId);
}
