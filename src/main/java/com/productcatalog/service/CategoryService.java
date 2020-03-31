package com.productcatalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcatalog.dao.CategoryDao;
import com.productcatalog.model.Category;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao dao;
	
	public Category registerCategory(Category category) {
		
		return dao.saveCategory(category);
	}
	
	public List<Category> getAllcats() {
		
	return	dao.categorylist();
	}

	public void deleteCategory(Integer id) {
		
		dao.deleteCat(id);
	}

	public Category getCatById(Integer id) {
		return dao.getCatById(id);
	}

	public void catUpdate(Category category) {
		dao.catUpdate(category);
	}

}
