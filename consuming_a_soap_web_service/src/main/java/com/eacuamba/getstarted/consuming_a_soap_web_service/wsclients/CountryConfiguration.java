package com.eacuamba.getstarted.consuming_a_soap_web_service.wsclients;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CountryConfiguration {

	@Bean
	public Jaxb2Marshaller jaxb2Marshaller() {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setContextPath("com.eacuamba.getstarted.consuming_a_soap_web_service.wsdl");
		return jaxb2Marshaller;
	}
	
	@Bean
	public CountryClient countryClient(Jaxb2Marshaller jaxb2Marshaller) {
		CountryClient countryClient = new CountryClient();
		countryClient.setDefaultUri("http://localhost:8082/ws");
		countryClient.setMarshaller(jaxb2Marshaller);
		countryClient.setUnmarshaller(jaxb2Marshaller);
		return countryClient;
	}
}
