package com.productcatalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcatalog.dao.ProductDao;
import com.productcatalog.model.Product;

@Service
public class ProductService {
	
	@Autowired
	ProductDao productdao;
	
	public Product registerProduct(Product product) {
		
		return productdao.registerProduct(product);
	}
	
	public List<Product> getAllProducts() {
		
		return productdao.getAllProducts();
	}
	
	public Product getProductById(Integer id) {
		
		return productdao.getProductById(id);
	}
	
	public void updateProduct(Product product) {
		
		 productdao.updateProduct(product);
	}
	
	public void deleteProduct(Integer id) {
		
		productdao.deleteProduct(id);
		
	}

}
