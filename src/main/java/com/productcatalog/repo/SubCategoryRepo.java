package com.productcatalog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productcatalog.model.SubCategory;

public interface SubCategoryRepo extends JpaRepository<SubCategory, Integer> {

}
