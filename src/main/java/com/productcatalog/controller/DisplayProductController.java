package com.productcatalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.productcatalog.model.Category;
import com.productcatalog.model.Product;
import com.productcatalog.model.SubCategory;
import com.productcatalog.service.CategoryService;
import com.productcatalog.service.ProductService;
import com.productcatalog.service.SubCategoryService;

@Controller
public class DisplayProductController {
	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	SubCategoryService SubcategoryService;


	

	@RequestMapping("/{sub}")
	public String showProduct(@PathVariable("sub") String subcat, ModelMap map) {
		
		System.out.println(subcat);
		List<Category> categories = categoryService.getAllcats();
		map.addAttribute("categories", categories);

		List<SubCategory> subcategories = SubcategoryService.getSubCats();
		map.addAttribute("subCategories", subcategories);

		List<Product> products = productService.getAllProducts();
		map.addAttribute("products", products);
		
		System.out.println("Subcategory is "+subcat);
		List<Product> pros = productService.getproductBySubCat(subcat);

		System.out.println(pros);
		map.addAttribute("pros", pros);
		map.addAttribute("product", new Product());
		return "products";

	}

}
