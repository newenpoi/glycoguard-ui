package com.openclassrooms.medilabo.glycoguardui.exceptions;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

	private final ErrorDecoder defaultErrorDecoder = new Default();
	
	@Override
	public Exception decode(String invoker, Response response) {
		
		if (invoker.contains("recupererPatient") && response.status() >= 400 && response.status() <= 499) {
			return new PatientBadRequestException(String.format("La requête recupererPatient n'a pu aboutir (%s).", response.status()));
		}
		
		return defaultErrorDecoder.decode(invoker, response);
	}

}
