package com.productcatalog.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.productcatalog.model.Address;
import com.productcatalog.model.City;
import com.productcatalog.model.Country;
import com.productcatalog.model.State;
import com.productcatalog.repo.AddressRepo;
import com.productcatalog.repo.CityRepo;
import com.productcatalog.repo.CountryRepo;
import com.productcatalog.repo.StateRepo;

@Repository
public class AddressDao {
	@Autowired
	CountryRepo countryRepo;
	
	@Autowired
	StateRepo stateRepo;
	
	@Autowired
	CityRepo cityRepo;
	
	@Autowired
	AddressRepo addressRepo;
	
public List<Country> getCountries(){
		
		return countryRepo.findAll();
	}


	public List<State> getStatesByCountryId(Integer countryId) {
		
		
		return stateRepo.findByCountry(countryRepo.findById(countryId).get());
	}


	public List<City> getCitiesByStateId(Integer stateId) {
		
		return cityRepo.findByState(stateRepo.findById(stateId).get());
	}
	
	public void saveCountry() {
		
		countryRepo.save(null);
	}
	public List<Address> getAllAddress() {
		
		return addressRepo.findAll();
	}
	
}
