package com.productcatalog.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.productcatalog.model.Category;
import com.productcatalog.model.Product;
import com.productcatalog.model.SubCategory;
import com.productcatalog.service.CategoryService;
import com.productcatalog.service.ProductService;
import com.productcatalog.service.SubCategoryService;

@Controller
public class ProductController {
	 public static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	SubCategoryService SubcategoryService;

	@GetMapping("/formProduct")
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

	@GetMapping("/saveProduct")
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

	@GetMapping("/getProducts")
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

	@PutMapping("/updateProduct/{id}")
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

	@PostMapping(value = "/updateProduct")
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

	@DeleteMapping("/deleteProduct/{id}")
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
	
	@GetMapping("/subcats/{id}")
	@ResponseBody
	public List<SubCategory> getSubCatByCat(@PathVariable("id") String cat){

		System.out.println("enter value is "+cat);

		List<SubCategory> subCats=SubcategoryService.getSubCatCat(cat);

		System.out.println(subCats);

		return subCats;
	}
}
