package com.productcatalog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productcatalog.model.SubCategory;
import java.lang.String;
import java.util.List;

public interface SubCategoryRepo extends JpaRepository<SubCategory, Integer> {

	List<SubCategory> findByCat(String cat);

	
}
