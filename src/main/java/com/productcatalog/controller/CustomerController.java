package com.productcatalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.productcatalog.model.Customer;
import com.productcatalog.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	CustomerService service;

	@RequestMapping("/customer")
	public String showCustomer(ModelMap map) {
		
		System.out.println("CustomerController.showCustomer");
		
		List<Customer>customers=service.getAllcustomers();
		map.addAttribute("customers",customers);
		map.addAttribute("customer", new Customer());
		
		return "customer";
	}
	
	

}
