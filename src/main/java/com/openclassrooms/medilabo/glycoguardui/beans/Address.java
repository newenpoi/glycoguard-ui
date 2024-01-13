package com.openclassrooms.medilabo.glycoguardui.beans;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Address {
	
	private Long id;
	
	private String number;
	
	@NotBlank
	private String street;
	
	@NotBlank
	private String zip;
	
	@NotBlank
	private String city;
	
	@NotBlank
	private String country;
}
