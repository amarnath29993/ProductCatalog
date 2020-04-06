package com.productcatalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.productcatalog.model.Product;
import com.productcatalog.service.ProductService;

@Controller
public class DisplayProductController {

	@Autowired
	ProductService productService;

	@RequestMapping("/{sub}")
	public String showProduct(@PathVariable("sub") String subcat) {
		System.out.println("Subcategory is "+subcat);
		List<Product> product = productService.getproductBySubCat(subcat);

		System.out.println(product);

		return "products";

	}

}
