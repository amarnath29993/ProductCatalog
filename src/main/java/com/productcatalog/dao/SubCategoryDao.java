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
		
		return subCatRepo.save(subcat);
	}
	
	public List<SubCategory> getSubCats() {
		
		return subCatRepo.findAll();
	}

	public SubCategory getCatById(Integer id) {
		return subCatRepo.findById(id).get();
	}

	public void updateSubCat(SubCategory subCategory) {
		
		subCatRepo.save(subCategory);
	}

	public void deleteSubCat(Integer id) {
		subCatRepo.deleteById(id);
		
	}

	public List<SubCategory> findSubCatByCat(String cat) {
		
		return subCatRepo.findByCat(cat);
	}
	
}
