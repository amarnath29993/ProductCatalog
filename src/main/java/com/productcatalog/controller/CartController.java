package com.productcatalog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.productcatalog.model.Address;
import com.productcatalog.model.Category;
import com.productcatalog.model.Country;
import com.productcatalog.model.Product;
import com.productcatalog.model.SubCategory;
import com.productcatalog.repo.UserRepo;
import com.productcatalog.service.AddressService;
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

	@Autowired
	AddressService addressService;

	@Autowired
	UserRepo userRepo;

	@RequestMapping("/cart/{id}")
	public String addToCart(@PathVariable("id") String pro, HttpServletRequest req, ModelMap map) {

		List<String> pros = (List<String>) req.getSession().getAttribute("PROD");
		if (pros == null) {
			pros = new ArrayList<>();
			req.getSession().setAttribute("PROD", pros);
		}
		pros.add(pro);
		req.getSession().setAttribute("PROD", pros);
		System.out.println("list of orders " + pros.size());
		Product product = productService.getProductByName(pro);
		System.out.println("add to cart msg ->" + product.getSubCategory());
		return "redirect:/" + product.getSubCategory();
	}

	@RequestMapping("/carts")
	public String displayCart(HttpServletRequest req, ModelMap map) {
		List<Product> carts = new ArrayList<Product>();
		List<String> pros = (List<String>) req.getSession().getAttribute("PROD");
		for (String pro : pros) {
			Product product = productService.getProductByName(pro);
			carts.add(product);
		}
		System.out.println("carts products");
		System.out.println(carts);
		map.addAttribute("carts", carts);
		List<Category> categories = categoryService.getAllcats();
		map.addAttribute("cats", categories);

		List<SubCategory> subcategories = subCategoryService.getSubCats();
		map.addAttribute("subCategories", subcategories);

		List<Product> products = productService.getAllProducts();
		map.addAttribute("products", products);

		return "cart";
	}

	@RequestMapping("/cartremove/{id}")
	public String removeToCart(@PathVariable("id") String pro, HttpServletRequest request, ModelMap map) {

		List<String> pros = (List<String>) request.getSession().getAttribute("PROD");

		if (pros == null) {
			pros = new ArrayList<>();
			request.getSession().setAttribute("PROD", pros);
		}
		pros.remove(pro);
		request.getSession().setAttribute("PROD", pros);

		System.out.println("list of orders " + pros.size());

		Product product = productService.getProductByName(pro);

		System.out.println("add to cart msg ->" + product.getSubCategory());

		return "redirect:/carts";
	}

	@RequestMapping("/proceed")
	public String proceed(HttpServletRequest request, ModelMap map) {

		System.out.println("hi   " + request.getUserPrincipal().getName());

		List<Country> countries = addressService.getCountries();
		map.addAttribute("countries", countries);
		map.addAttribute("add", new Address());
		if (request.getUserPrincipal() != null) {
			map.addAttribute("user", userRepo.findByEmailId(request.getUserPrincipal().getName()).get().getUserName());
		} else {
			map.addAttribute("user", null);
		}
		List<Address> ads = addressService.getAllAddress();
		System.out.println(ads);
		map.addAttribute("ads", ads);

		return "proceed";
	}

	@RequestMapping("/buy")

	public String buyProduct() {
		return "payment";

	}

	@RequestMapping("/purchase")

	public String purchaseProduct(HttpServletRequest request, ModelMap map) {

		List<Product> carts = new ArrayList<Product>();

		List<String> pros = (List<String>) request.getSession().getAttribute("PROD");

		for (String pro : pros) {
			Product product = productService.getProductByName(pro);

			carts.add(product);
		}
		System.out.println("carts products");
		System.out.println(carts);
		map.addAttribute("pros", carts);

		return "/purchase";

	}
}
