package com.productcatalog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productcatalog.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
