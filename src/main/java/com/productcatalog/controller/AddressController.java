package com.productcatalog.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.productcatalog.model.Address;
import com.productcatalog.model.City;
import com.productcatalog.model.Country;
import com.productcatalog.model.State;
import com.productcatalog.model.Users;
import com.productcatalog.repo.UserRepo;
import com.productcatalog.service.AddressService;
import com.productcatalog.service.CustomerService;

@Controller
public class AddressController {
	@Autowired
	AddressService addressService;

	@Autowired
	CustomerService custService;
	
	@Autowired
	UserRepo userRepo;
	
	@RequestMapping("/address")
	public String formAddress(HttpServletRequest req, ModelMap map) {
		Principal userPrincipal=req.getUserPrincipal();
		System.out.println(userPrincipal.getName());
		
		Optional<Users> user=userRepo.findByEmailId(userPrincipal.getName());
		System.out.println(user);

		List<Country> countries = addressService.getCountries();
		map.addAttribute("countries", countries);
		map.addAttribute("add", new Address());
		return "address";
	}

	@RequestMapping(value = "/address", method = RequestMethod.POST)
	public String regAddress(@ModelAttribute("add") Address address, ModelMap map) {

		custService.saveAddress(address);

		map.addAttribute("add", new Address());
		return "address";
	}

	@RequestMapping("/getStates/{id}")
	@ResponseBody
	public List<State> getStates(@PathVariable("id") Integer countryId, ModelMap map) {

		List<State> countries = addressService.getStatesByCountryId(countryId);
		return countries;
	}

	@RequestMapping("/getCities/{id}")
	@ResponseBody
	public List<City> getCites(@PathVariable("id") Integer stateId, ModelMap map) {

		List<City> cities = addressService.getCitiesByStateId(stateId);

		return cities;
	}

}
