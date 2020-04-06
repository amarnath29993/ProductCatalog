package com.productcatalog.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productcatalog.model.Product;
import java.lang.String;

public interface ProductRepo extends JpaRepository<Product, Integer> {
//public List<Product> findProductBySubcategory(String subCategory);
	List<Product> findBySubCategory(String subcategory);
}
