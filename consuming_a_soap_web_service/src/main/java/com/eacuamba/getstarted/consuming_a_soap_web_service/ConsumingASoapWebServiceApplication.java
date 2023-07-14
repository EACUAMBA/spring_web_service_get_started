package com.eacuamba.getstarted.consuming_a_soap_web_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.eacuamba.getstarted.consuming_a_soap_web_service.wsclients.CountryClient;
import com.eacuamba.getstarted.consuming_a_soap_web_service.wsdl.GetCountryResponse;

@SpringBootApplication
public class ConsumingASoapWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingASoapWebServiceApplication.class, args);
	}
	
	  @Bean
	  CommandLineRunner lookup(CountryClient quoteClient) {
	    return args -> {
	      String country = "Spain";

	      if (args.length > 0) {
	       // country = args[0];
	      }
	      GetCountryResponse response = quoteClient.getCountry(country);
	      System.err.println(response.getCountry().getCurrency());
	    };
	  }

}
