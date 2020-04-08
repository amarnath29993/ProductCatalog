package com.productcatalog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productcatalog.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
