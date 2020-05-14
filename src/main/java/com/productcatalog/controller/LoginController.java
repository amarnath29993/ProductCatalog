package com.productcatalog.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.productcatalog.model.Category;
import com.productcatalog.model.Product;
import com.productcatalog.model.SubCategory;
import com.productcatalog.model.Users;
import com.productcatalog.repo.UserRepo;
import com.productcatalog.service.CategoryService;
import com.productcatalog.service.ProductService;
import com.productcatalog.service.SubCategoryService;

@Controller
public class LoginController {

	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	SubCategoryService subCategoryService;
	@Autowired
	UserRepo userRepo;

	@RequestMapping("/login1")
	public String login(HttpServletRequest req, ModelMap map) {

		map.addAttribute("user", userRepo.findByEmailId(req.getUserPrincipal().getName()).get());

		List<String> pros = (List<String>)req.getSession().getAttribute("PROD");
		if(pros==null) {
			pros=new ArrayList<String>();
			req.getSession().setAttribute("PROD", pros);
		}
		req.getSession().setAttribute("PROD", pros);
		
		map.addAttribute("cartCount",pros.size());
		List<Category>categories=categoryService.getAllcats();
		map.addAttribute("categories", categories);

		List<SubCategory> subcategories = subCategoryService.getSubCats();
		map.addAttribute("subCategories", subcategories);

		List<Product> products = productService.getAllProducts();
		map.addAttribute("products", products);

		return "userForm";
	}

	@RequestMapping("/userdetails/{username}")
	public String userDetails(@PathVariable("username") String username, ModelMap map) {

		System.out.println(username);

		Optional<Users> user = userRepo.findByUserName(username);

		map.addAttribute("user", user.get());

		return "userData";
	}

}
