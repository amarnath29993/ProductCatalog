package com.productcatalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcatalog.dao.SubCategoryDao;
import com.productcatalog.model.SubCategory;

@Service
public class SubCategoryService {
	
	@Autowired
	SubCategoryDao subDao;

	public SubCategory registetSubCat(SubCategory subcat) {
		// TODO Auto-generated method stub
		
	return	subDao.saveSubcat(subcat);
		
		
		
	}
	
	public  List<SubCategory>  getSubCats() {
		
		return subDao.getSubCats();
	}

	public SubCategory getSubCatById(Integer id) {
		// TODO Auto-generated method stub
		return subDao.getCatById(id);
	}

	public void updateSubCat(SubCategory subCategory) {
		// TODO Auto-generated method stub
		
		subDao.updateSubCat(subCategory);
		
	}

	public void deleteSubCat(Integer id) {
		// TODO Auto-generated method stub
		
		subDao.deleteSubCat(id);
		
	}

}
