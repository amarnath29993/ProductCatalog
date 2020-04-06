package com.productcatalog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productcatalog.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
	
	

}
