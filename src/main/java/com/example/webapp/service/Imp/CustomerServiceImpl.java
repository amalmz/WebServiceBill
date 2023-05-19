package com.example.webapp.service.Imp;


import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.webapp.entity.CustomerEntity;
import com.example.webapp.repository.CustomerRepository;
import com.example.webapp.service.CustomerService;

@WebService(endpointInterface = "com.example.webapp.service.CustomerService", serviceName="CustomerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired 
	private CustomerRepository customerRepository  ;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public CustomerEntity getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }
    @Override
    public CustomerEntity getCustomerByIdOrCustCode(Long customerId, String custCode) {
        return customerRepository.findCustomerByIdOrCustCode(customerId, custCode);
    }
}
