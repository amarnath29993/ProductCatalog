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
import com.productcatalog.repo.UserRepo;
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
	SubCategoryService subcategoryService;


	@Autowired
	UserRepo userRepo;

	@RequestMapping("/{sub}")
	public String showProduct(@PathVariable("sub") String subcat,HttpServletRequest req ,ModelMap map) {
		
		if(req.getUserPrincipal()!=null) {
			map.addAttribute("user", userRepo.findByEmailId(req.getUserPrincipal().getName()).get());
		}
		else {
			map.addAttribute("User",null);
		}
		List<String>products=(List<String>)req.getSession().getAttribute("PROD");
		if(products==null) {
			products=new ArrayList<>();
			req.getSession().setAttribute("PROD", products);
		}
		req.getSession().setAttribute("PROD", products);
		
		map.addAttribute("cartCount",products.size());
		
		
		List<Category> categories = categoryService.getAllcats();
		map.addAttribute("categories", categories);

		List<SubCategory> subcategories = subcategoryService.getSubCats();
		map.addAttribute("subCategories", subcategories);

		List<Product> products1 = productService.getAllProducts();
		map.addAttribute("products", products1);
		
		System.out.println("Subcategory is "+subcat);
		List<Product> pros = productService.getproductBySubCat(subcat);

		System.out.println(pros);
		map.addAttribute("pros", pros);
		map.addAttribute("product", new Product());
		return "products";

	}
	@RequestMapping("/details/{id}")
	public String showDetails(@PathVariable("id")Integer id,HttpServletRequest req,ModelMap map) {
		
		if(req.getUserPrincipal()!=null) {
			map.addAttribute("users",userRepo.findByEmailId(req.getUserPrincipal().getName()).get());
		}
		else {
			map.addAttribute("user",null);
		}
		List<String> pros=(List<String>)req.getSession().getAttribute("PROD");
		
		if(pros==null) {
			pros=new ArrayList<String>();
			req.getSession().setAttribute("PROD", pros);
		}
		
		req.getSession().setAttribute("PROD", pros);
		map.addAttribute("cartCount",pros.size());
		
		System.out.println(id);
		Product product=productService.getProductById(id);
		
		map.addAttribute("product",product);		
		return "single";
	}

}
