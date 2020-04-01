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

import com.productcatalog.model.Category;
import com.productcatalog.service.CategoryService;

@Controller
public class CategoryController {
	public static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private CategoryService service;

	@GetMapping("/category")
	public String showCategory(ModelMap map) {

		System.out.println("ProductController.showcategory()");
		List<Category> cats = service.getAllcats();
		map.addAttribute("cats", cats);
		map.addAttribute("cat", new Category());
		return "category";
	}

	@PostMapping(value = "/category")
	public String RegisterCategory(@ModelAttribute("category") Category category, ModelMap map) {

		System.out.println(category);
		Category cat = service.registerCategory(category);
		System.out.println(cat.getCategoryId() + " is saved....");
		map.addAttribute("cat", new Category());
		List<Category> cats = service.getAllcats();
		map.addAttribute("cats", cats);
		return "category";
	}

	@GetMapping(value = "/categorylist")
	public String categorylist(ModelMap map) {
		List<Category> cats = service.getAllcats();

		System.out.println(cats);

		map.addAttribute("cats", cats);
		map.addAttribute("cat", new Category());
		return "category";
	}

	@DeleteMapping(value = "/delete/{id}")
	public String categoryDelete(@PathVariable("id") Integer id, ModelMap map) {

		System.out.println(id + " is deleted...");

		service.deleteCategory(id);

		List<Category> cats = service.getAllcats();

		map.addAttribute("cats", cats);
		map.addAttribute("cat", new Category());
		return "category";
	}

	@PutMapping(value = "/update/{id}")
	public String categoryUpdate(@PathVariable("id") Integer id, ModelMap map) {

		Category proCat = service.getCatById(id);

		List<Category> cats = service.getAllcats();

		map.addAttribute("cats", cats);
		map.addAttribute("cat", proCat);
		System.out.println(id + " is updated...");
		return "categoryUpdate";
	}

	@PostMapping(value = "/update")
	public String categoryUpdating(@ModelAttribute("category") Category category, ModelMap map) {

		service.catUpdate(category);

		List<Category> cats = service.getAllcats();

		map.addAttribute("cats", cats);
		map.addAttribute("cat", new Category());
		System.out.println(category.getCategoryId() + " is updated...");
		return "category";
	}

}
