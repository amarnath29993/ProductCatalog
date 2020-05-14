package com.productcatalog.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.productcatalog.model.Customer;
import com.productcatalog.model.Role;
import com.productcatalog.model.Users;
import com.productcatalog.repo.RoleRepo;
import com.productcatalog.repo.UserRepo;
import com.productcatalog.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	RoleRepo roleRepo;
	
	@RequestMapping("/cust")
	public String formCustomer(ModelMap map) {
		
		System.out.println("CustomerController.formCustomer()");
		
		map.addAttribute("user", new Users());
		return "registration";
	}
	
	@RequestMapping(value = "/cust",method = RequestMethod.POST)
	public String registerCustomer(@ModelAttribute()Users user,ModelMap map) {
		
		Set<Role> setrole=new HashSet<Role>();
		Role role=new Role();
		role.setRole("admin");
		setrole.add(role);
		user.setRoles(setrole);
		System.out.println(user);
		userRepo.save(user);
		
		map.addAttribute("user", new Users());
		
		return "redirect:/";
	}
	

	@RequestMapping("/customers")
	public String getCustomers(ModelMap map) {
		
		List<Customer> customers=customerService.getCustomers();
		
		System.out.println(customers);
		
		map.addAttribute("customers", customers);
		return "customersList";
	}
	
	@RequestMapping("/email")
	public String emailId() {
		return "updateEmail";
	}
	@RequestMapping("/password")
	public String password() {
		return "updatepassword";
	}
	
	
	
	
	/*@RequestMapping(value = "/update/{id}")
	public String customerUpdate(@PathVariable("id") Integer id, ModelMap map) {

		Customer proCust = service.getCustomerById(id);

		List<Customer> custs = service.getAllcustomers();

		map.addAttribute("custs", custs);
		map.addAttribute("cust", proCust);
		System.out.println(id + " is updated...");
		return "customerUpdate";
	}*/
	/*@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String customerUpdating(@ModelAttribute("customer") Customer customer, ModelMap map) {

		service.customerUpdate(customer);

		List<Customer> custs = service.getAllcustomers();

		map.addAttribute("custs", custs);
		map.addAttribute("cust", new Customer());
		System.out.println(customer.getCustomerId() + " is updated...");
		return "customer";
	}*/



}
