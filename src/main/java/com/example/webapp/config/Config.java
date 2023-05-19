package com.example.webapp.config;

import javax.servlet.Servlet;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.apache.cxf.jaxws.EndpointImpl;

import com.example.webapp.repository.CustomerRepository;
import com.example.webapp.service.CustomerService;
import com.example.webapp.service.Imp.CustomerServiceImpl;
import javax.xml.ws.Endpoint;

@Configuration
@EnableJpaRepositories("com.example.webapp.repository")
public class Config {
	   @Autowired
	    private CustomerRepository customerRepository;

	    @Bean
	    public ServletRegistrationBean<Servlet> servletRegistrationBean(ApplicationContext context) {
	        return new ServletRegistrationBean<Servlet>(new CXFServlet(), "/api/*");
	    }

	    @Bean(destroyMethod = "shutdown")
	    public Bus cxf() {
	        return new SpringBus();
	    }

	    @Bean
	    public CustomerService customerService() {
	        return new CustomerServiceImpl(customerRepository);
	    }

	    @Bean
	    public Endpoint customerServiceEndpoint(Bus bus, CustomerService customerService) {
	        EndpointImpl endpoint = new EndpointImpl(bus, customerService);
	        endpoint.publish("/customerService");
	        return endpoint;
	    }
}


