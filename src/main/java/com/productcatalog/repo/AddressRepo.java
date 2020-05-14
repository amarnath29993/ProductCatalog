package com.productcatalog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productcatalog.model.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}
