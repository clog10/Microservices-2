package com.paymentchain.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paymentchain.customer.entities.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

    public Customer findByCode(String code);

}
