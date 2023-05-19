package com.example.webapp.service;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.example.webapp.entity.CustomerEntity;
@WebService
public interface CustomerService {
	@WebMethod
    @WebResult(name = "customer")
    CustomerEntity getCustomerById(@WebParam(name = "customerId") Long customerId);
	@WebMethod
	@WebResult(name = "customer")
	CustomerEntity getCustomerByIdOrCustCode(@WebParam(name = "customerId") Long customerId, @WebParam(name = "custCode") String custCode);
}
