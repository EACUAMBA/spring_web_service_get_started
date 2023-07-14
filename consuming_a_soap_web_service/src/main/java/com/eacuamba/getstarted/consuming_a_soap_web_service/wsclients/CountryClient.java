package com.eacuamba.getstarted.consuming_a_soap_web_service.wsclients;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.eacuamba.getstarted.consuming_a_soap_web_service.wsdl.GetCountryRequest;
import com.eacuamba.getstarted.consuming_a_soap_web_service.wsdl.GetCountryResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CountryClient extends WebServiceGatewaySupport {

	public GetCountryResponse getCountry(String name) {

		GetCountryRequest request = new GetCountryRequest();
		request.setName(name);

		log.info("Request looking for {}", name);

		GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8082/ws/countries", request,
				new SoapActionCallback("http://localhost:8082/ws/countries"));

		return response;
	}
}
