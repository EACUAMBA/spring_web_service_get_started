package com.eacuamba.get_starteds.producing_a_soap_web_service.configurations;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfiguration {

	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatchServlet(ApplicationContext applicationContext){
		MessageDispatcherServlet dispatcherServlet = new MessageDispatcherServlet();
		dispatcherServlet.setApplicationContext(applicationContext);
		dispatcherServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(dispatcherServlet, "/ws/*");
	}
	
	
	@Bean
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema) {
		DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
		defaultWsdl11Definition.setPortTypeName("CountriesPort");
		defaultWsdl11Definition.setLocationUri("/ws");
		defaultWsdl11Definition.setTargetNamespace("http://spring.io/guides/gs-producing-web-service");
		defaultWsdl11Definition.setSchema(countriesSchema);
		return defaultWsdl11Definition;
	}
	
	@Bean
	public XsdSchema coutriesSchema() {
		return new SimpleXsdSchema(new ClassPathResource("countries.xsd"));
	}
}
