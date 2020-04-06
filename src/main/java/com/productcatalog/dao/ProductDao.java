package com.productcatalog.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.productcatalog.model.Product;
import com.productcatalog.repo.ProductRepo;

@Repository
public class ProductDao {

	@Autowired
	ProductRepo productrepo;

	public Product registerProduct(Product product) {

		return productrepo.save(product);

	}

	public List<Product> getAllProducts() {

		return productrepo.findAll();
	}

	public Product getProductById(Integer id) {

		return productrepo.findById(id).get();
	}

	public void updateProduct(Product product) {

		productrepo.save(product);
	}

	public void deleteProduct(Integer id) {

		productrepo.deleteById(id);
	}

	public List<Product> getProductBySubCat(String subCat) {
		return productrepo.findBySubCategory(subCat);
	}

}
