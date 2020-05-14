package com.productcatalog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
public class CartController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	SubCategoryService subCategoryService;

	@Autowired
	ProductService productService;

	@RequestMapping("/cart/{id}")
	public String addtoCart(@PathVariable("id")String pro, HttpServletRequest req, ModelMap map) {
		List<String> pros=(List<String>)req.getSession().getAttribute("PROD");
		if(pros==null) {
			pros=new ArrayList<>();
			req.getSession().setAttribute("PROD", pros);
		}
		pros.add(pro);
		req.getSession().setAttribute("PROD", pros);
			System.out.println("list of orders "+pros.size());
			Product product=productService.getProductByName(pro);
			System.out.println("add to cart msg ->"+product.getProductName());
		return "redirect:/"+product.getProductName();
	}
}
