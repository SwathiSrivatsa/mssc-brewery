package com.swa.microservices.msscbrewery.web.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.swa.microservices.msscbrewery.web.model.CustomerDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDTO getCustomerById(UUID custId) {
		
		return CustomerDTO.builder().customerId(UUID.randomUUID())
				.customerName("Swathi")
				.build();
	}

	@Override
	public CustomerDTO createNewCustomer(CustomerDTO custDto) {
		
		return CustomerDTO.builder()
				.customerId(UUID.randomUUID())
				.build();
	}

	@Override
	public void updateById(CustomerDTO custDto, UUID custId) {

		
	}

	@Override
	public void deleteById(UUID custId) {
		
		log.debug("Deleting the Customer..");
	}

}
