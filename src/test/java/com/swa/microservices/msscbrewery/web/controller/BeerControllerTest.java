package com.swa.microservices.msscbrewery.web.controller;


import static org.mockito.ArgumentMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.swa.microservices.msscbrewery.web.model.BeerDTO;
import com.swa.microservices.msscbrewery.web.services.BeerService;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
//@AutoConfigureMockMvc

@WebMvcTest(BeerController.class)
class BeerControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	BeerService beerService;
	
	@Autowired
	ObjectMapper objectMapper;
	
	BeerDTO validbeer;
	
	@BeforeEach
	void setUp() throws Exception {
		
		validbeer=BeerDTO.builder().id(UUID.randomUUID())
				.beerName("Galaxy Cats")
				.beerStyle("PALE_ALE")
				.upc(123456789L)
				.build();
	}

	@Test
	void testGetBeer() throws Exception {

		given(beerService.getBeerById(any(UUID.class))).willReturn(validbeer);
		
		mockMvc.perform(get("/api/v1/beer/"+validbeer.getId().toString())
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id", is(validbeer.getId().toString())))
				.andExpect(jsonPath("$.beerName", is("Galaxy Cats")));
				
	}

	@Test
	void testHandlePost() {
		fail("Not yet implemented");
	}

	@Test
	void testHandleUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteById() {
		fail("Not yet implemented");
	}

}
