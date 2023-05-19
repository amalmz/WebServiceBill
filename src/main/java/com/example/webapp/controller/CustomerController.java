package com.example.webapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webapp.entity.CustomerEntity;
import com.example.webapp.service.CustomerService;

@RestController
@RequestMapping("customers")
public class CustomerController {
	  private final CustomerService customerService;

	    public CustomerController(CustomerService customerService) {
	        this.customerService = customerService;
	    }
	    @PostMapping("/find")
	    public ResponseEntity<CustomerEntity> getCustomer(@RequestBody CustomerEntity customer) {
	    String custCode = customer.getCUSTCODE();
		Long id = customer.getId();
		CustomerEntity retrievedCustomer = customerService.getCustomerByIdOrCustCode(id, custCode);
	    return ResponseEntity.ok(retrievedCustomer);
	    }
}
