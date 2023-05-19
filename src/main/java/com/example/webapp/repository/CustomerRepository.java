package com.example.webapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.webapp.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>  {
	@Query("SELECT c FROM CustomerEntity c WHERE c.CUSTOMER_ID = :id")
	Optional<CustomerEntity> findCustomer(@Param("id") Long id);
	@Query("SELECT c FROM CustomerEntity c WHERE c.CUSTOMER_ID = :id OR c.CUSTCODE = :custcode")
    CustomerEntity findCustomerByIdOrCustCode(@Param("id") Long id, @Param("custcode") String custcode);
}
