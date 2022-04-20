package com.swa.microservices.msscbrewery.web.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.swa.microservices.msscbrewery.web.model.CustomerDTO;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDTO getCustomerById(UUID custId) {
		
		return CustomerDTO.builder().customerId(UUID.randomUUID())
				.customerName("Swathi")
				.build();
	}

}
