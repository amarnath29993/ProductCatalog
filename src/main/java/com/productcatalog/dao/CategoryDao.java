package com.productcatalog.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.productcatalog.model.Category;
import com.productcatalog.repo.CategoryRepo;

@Repository
public class CategoryDao {

	@Autowired
	CategoryRepo repository;
	
	public Category saveCategory(Category category) {
		
		return repository.save(category);
	}
	
	public List<Category> categorylist() {
		
		return repository.findAll();
	}

	public void deleteCat(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	public Category getCatById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	public void catUpdate(Category category) {
		// TODO Auto-generated method stub
		repository.save(category);
	}
}
