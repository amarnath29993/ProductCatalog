package com.productcatalog.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.productcatalog.model.Category;
import com.productcatalog.model.SubCategory;
import com.productcatalog.service.CategoryService;
import com.productcatalog.service.SubCategoryService;

@Controller
public class SubCategoryController {
	public static final Logger logger = LoggerFactory.getLogger(SubCategoryController.class);

	@Autowired
	SubCategoryService serviceSubCat;

	@Autowired
	CategoryService serviceProduct;

	@RequestMapping("/subcategory")
	public String showSubCategory(ModelMap map) {

		System.out.println("ProductController.showSubCategory()");
		List<Category> cats = serviceProduct.getAllcats();
		map.addAttribute("cats", cats);
		List<SubCategory> subCats = serviceSubCat.getSubCats();
		map.addAttribute("subcats", subCats);
		map.addAttribute("subcategory", new SubCategory());
		return "subCategory";
	}

	@RequestMapping(value = "/subcategory", method = RequestMethod.POST)
	public String registerSubCategory(@ModelAttribute("subcategory") SubCategory subcat, ModelMap map) {

		System.out.println("subCat values " + subcat);
		SubCategory savedCat = serviceSubCat.registetSubCat(subcat);
		System.out.println(savedCat.getSubCategoryId() + " is saved successfully...");
		List<Category> cats = serviceProduct.getAllcats();
		map.addAttribute("cats", cats);
		List<SubCategory> subcats = serviceSubCat.getSubCats();
		map.addAttribute("subcats", subcats);
		map.addAttribute("subcategory", new SubCategory());
		return "subCategory";
	}

	@RequestMapping("/subcats")
	public String getCats(ModelMap map) {

		List<SubCategory> subCats = serviceSubCat.getSubCats();
		System.out.println("subcategories " + subCats);
		map.addAttribute("subcats", subCats);
		List<Category> cats = serviceProduct.getAllcats();
		map.addAttribute("cats", cats);
		map.addAttribute("subcategory", new SubCategory());
		return "subCategory";
	}

	@RequestMapping(value = "/deleteSubCat/{id}")
	public String categoryDelete(@PathVariable("id") Integer id, ModelMap map) {

		System.out.println(id + " is deleted...");

		serviceSubCat.deleteSubCat(id);

		List<SubCategory> subCats = serviceSubCat.getSubCats();
		System.out.println("subcategories " + subCats);
		map.addAttribute("subcats", subCats);
		List<Category> cats = serviceProduct.getAllcats();
		map.addAttribute("cats", cats);
		map.addAttribute("subcategory", new SubCategory());
		return "subCategory";
	}

	@RequestMapping(value = "/updateSubCat/{id}")
	public String categoryUpdate(@PathVariable("id") Integer id, ModelMap map) {

		System.out.println("form update " + id);

		SubCategory subCategory = serviceSubCat.getSubCatById(id);
		List<SubCategory> subCats = serviceSubCat.getSubCats();
		System.out.println("subcategories " + subCats);
		map.addAttribute("subcats", subCats);
		map.addAttribute("subcategory", subCategory);
		return "subCategoryUpdate";
	}

	@RequestMapping(value = "/updateSubCat", method = RequestMethod.POST)
	public String categoryUpdating(@ModelAttribute("subCategory") SubCategory subCategory, ModelMap map) {

		System.out.println(subCategory);
		serviceSubCat.updateSubCat(subCategory);

		List<SubCategory> subCats = serviceSubCat.getSubCats();
		System.out.println("subcategories " + subCats);
		map.addAttribute("subcats", subCats);
		List<Category> cats = serviceProduct.getAllcats();
		map.addAttribute("cats", cats);
		map.addAttribute("subcategory", new SubCategory());
		return "subCategory";
	}

}
