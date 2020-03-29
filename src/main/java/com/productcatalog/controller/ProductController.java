package com.productcatalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.productcatalog.model.Category;
import com.productcatalog.model.Product;
import com.productcatalog.model.SubCategory;
import com.productcatalog.service.CategoryService;
import com.productcatalog.service.ProductService;
import com.productcatalog.service.SubCategoryService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	SubCategoryService SubcategoryService;

	@RequestMapping("/formProduct")
	public String formProduct(ModelMap map) {

		System.out.println("ProductController.formProduct()");

		List<Category> categories = categoryService.getAllcats();
		map.addAttribute("categories", categories);

		List<SubCategory> subcategories = SubcategoryService.getSubCats();
		map.addAttribute("subCategories", subcategories);

		List<Product> products = productService.getAllProducts();
		map.addAttribute("products", products);
		
		map.addAttribute("product", new Product());
		return "product";
	}

	@RequestMapping("/saveProduct")
	public String registerProduct(@ModelAttribute("product") Product product, ModelMap map) {

		System.out.println(product);

		Product saved = productService.registerProduct(product);

		System.out.println("product value is " + saved.getProductId());
		
		List<Product> products = productService.getAllProducts();
		map.addAttribute("products", products);

		List<Category> categories = categoryService.getAllcats();
		map.addAttribute("categories", categories);

		List<SubCategory> subcategories = SubcategoryService.getSubCats();
		map.addAttribute("subCategories", subcategories);

		map.addAttribute("product", new Product());
		return "product";
	}

	@RequestMapping("/getProducts")
	public String getAllProducts(ModelMap map) {

		List<Product> products = productService.getAllProducts();
		map.addAttribute("products", products);

		List<Category> categories = categoryService.getAllcats();
		map.addAttribute("categories", categories);

		List<SubCategory> subcategories = SubcategoryService.getSubCats();
		map.addAttribute("subCategories", subcategories);

		map.addAttribute("product", new Product());

		return "product";
	}

	@RequestMapping("/updateProduct/{id}")
	public String getproductById(@PathVariable("id") Integer id, ModelMap map) {

		System.out.println("from update " + id);
		Product proMaster = productService.getProductById(id);
		System.out.println(proMaster);

		map.addAttribute("product", proMaster);

		List<Category> categories = categoryService.getAllcats();
		map.addAttribute("categories", categories);

		List<SubCategory> subcategories = SubcategoryService.getSubCats();
		map.addAttribute("subCategories", subcategories);

		List<Product> products = productService.getAllProducts();
		map.addAttribute("products", products);

		return "updateProduct";
	}

	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product") Product proMaster, ModelMap map) {

		productService.updateProduct(proMaster);
		
		List<Category> categories = categoryService.getAllcats();
		map.addAttribute("categories", categories);

		List<SubCategory> subcategories = SubcategoryService.getSubCats();
		map.addAttribute("subCategories", subcategories);

		List<Product> products = productService.getAllProducts();
		map.addAttribute("products", products);
		
		map.addAttribute("product", new Product());
		return "product";

	}

	@RequestMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable("id") Integer id,ModelMap map) {

		productService.deleteProduct(id);

		List<Category> categories = categoryService.getAllcats();
		map.addAttribute("categories", categories);

		List<SubCategory> subcategories = SubcategoryService.getSubCats();
		map.addAttribute("subCategories", subcategories);

		List<Product> products = productService.getAllProducts();
		map.addAttribute("products", products);
		
		map.addAttribute("product", new Product());

		return "product";
	}

}
