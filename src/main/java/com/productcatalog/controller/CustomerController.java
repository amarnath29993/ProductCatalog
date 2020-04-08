package com.productcatalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.productcatalog.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	CustomerService service;

	@RequestMapping("/customer")
	public String show() {
		
		System.out.println("Hello");

		return "customer";
	}

}
