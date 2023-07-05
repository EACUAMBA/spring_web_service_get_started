package com.eacuamba.get_starteds.producing_a_soap_web_service.endpoints;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.eacuamba.get_starteds.producing_a_soap_web_service.CountryRepository;
import com.eacuamba.get_starteds.producing_a_soap_web_service.models.GetCountryRequest;
import com.eacuamba.get_starteds.producing_a_soap_web_service.models.GetCountryResponse;

@Endpoint
public class CountryEndpoint {
	private static final String NAMESPACE = "http://spring.io/guides/gs-producing-web-service";
	
	private final CountryRepository countryRepository;
	
	public CountryEndpoint(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
	
	@PayloadRoot(namespace = NAMESPACE, localPart = "getCountryRequest")
	@ResponsePayload
	public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
		GetCountryResponse response = new GetCountryResponse();
		
		 response.setCountry(countryRepository.findName(request.getName()));
		 
		return response;
	}
}
