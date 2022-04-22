package com.swa.microservices.msscbrewery.web.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDTO {

	@Nullable
	private UUID id;
	
	@NotBlank
	private String beerName;
	
	@NotBlank
	private String beerStyle;
	
	@Positive
	private Long upc;
}
