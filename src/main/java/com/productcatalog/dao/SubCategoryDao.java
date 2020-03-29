package com.productcatalog.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.productcatalog.model.SubCategory;
import com.productcatalog.repo.SubCategoryRepo;

@Repository
public class SubCategoryDao {

	@Autowired
	SubCategoryRepo subCatRepo;

	public SubCategory saveSubcat(SubCategory subcat) {
		// TODO Auto-generated method stub
		
		return subCatRepo.save(subcat);
	}
	
	public List<SubCategory> getSubCats() {
		
		return subCatRepo.findAll();
	}

	public SubCategory getCatById(Integer id) {
		// TODO Auto-generated method stub
		return subCatRepo.findById(id).get();
	}

	public void updateSubCat(SubCategory subCategory) {
		// TODO Auto-generated method stub
		
		subCatRepo.save(subCategory);
	}

	public void deleteSubCat(Integer id) {
		// TODO Auto-generated method stub
		subCatRepo.deleteById(id);
		
	}
	
}
