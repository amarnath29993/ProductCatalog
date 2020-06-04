package com.productcatalog.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.productcatalog.model.Product;
import com.productcatalog.repo.ProductRepo;

@Repository
public class ProductDao {

	@Autowired
	ProductRepo productRepo;

	public Product registerProduct(Product product) {

		return productRepo.save(product);

	}

	public List<Product> getAllProducts() {

		return productRepo.findAll();
	}

	public Product getProductById(Integer id) {

		return productRepo.findById(id).get();
	}

	public void updateProduct(Product product) {

		productRepo.save(product);
	}

	public void deleteProduct(Integer id) {

		productRepo.deleteById(id);
	}

	public List<Product> getProductBySubCat(String subCat) {
		System.out.println(subCat);
		
		return productRepo.findBySubCategory(subCat);
	}
	public Product getProductByName(String pro) {
		return productRepo.findByProductName(pro);
	}

}
