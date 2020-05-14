package com.productcatalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.productcatalog.model.City;
import com.productcatalog.model.Country;
import com.productcatalog.model.State;
import com.productcatalog.repo.CityRepo;
import com.productcatalog.repo.CountryRepo;
import com.productcatalog.repo.StateRepo;

@Controller
public class CountryController {
	@Autowired
	CountryRepo countryRepo;
	@Autowired
	StateRepo stateRepo;
	@Autowired
	CityRepo cityRepo;

	@RequestMapping(value = "/cont", method = RequestMethod.POST)
	public String saveCountry(@ModelAttribute("country") Country country, ModelMap map) {

		countryRepo.save(country);

		map.addAttribute("country", new Country());

		return "country";
	}

	@RequestMapping("/cont")
	public String getCountryform(ModelMap map) {
		map.addAttribute("country", new Country());
		return "country";
	}

	@RequestMapping("/city")
	public String getCityForm(ModelMap map) {

		List<Country> countries = countryRepo.findAll();
		map.addAttribute("countries", countries);

		List<State> states = stateRepo.findAll();

		System.out.println(states);

		map.addAttribute("states", states);

		map.addAttribute("city", new City());
		return "city";
	}

	@RequestMapping(value = "/city", method = RequestMethod.POST)
	public String getCountryReg(@ModelAttribute("city") City city, ModelMap map) {

		//Country country = countryRepo.findById(city.getState().getCountry().getCountryId()).get();

		State state = stateRepo.findById(city.getState().getStateId()).get();

		System.out.println(state);

		// state.setCountry(country);

		City c = new City();
		c.setName(city.getName());
		c.setState(state);

		cityRepo.save(c);

		List<Country> countries = countryRepo.findAll();
		map.addAttribute("countries", countries);

		List<State> states = stateRepo.findAll();
		map.addAttribute("states", states);

		map.addAttribute("city", new City());
		return "city";
	}

	@RequestMapping(value = "/state", method = RequestMethod.POST)
	public String StateForm(@ModelAttribute("state") State state, ModelMap map) {

		Country c = countryRepo.findById(state.getCountry().getCountryId()).get();

		State s = new State();
		s.setName(state.getName());
		s.setCountry(c);
		stateRepo.save(s);

		System.out.println("state saved successfully");

		List<Country> countries = countryRepo.findAll();
		map.addAttribute("countries", countries);
		map.addAttribute("state", new State());
		return "state";
	}

	@RequestMapping(value = "/state", method = RequestMethod.GET)
	public String saveState(ModelMap map) {

		List<Country> countries = countryRepo.findAll();

		map.addAttribute("countries", countries);
		map.addAttribute("state", new State());
		return "state";
	}
}
