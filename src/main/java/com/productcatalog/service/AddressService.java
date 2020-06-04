package com.productcatalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcatalog.dao.AddressDao;
import com.productcatalog.model.Address;
import com.productcatalog.model.City;
import com.productcatalog.model.Country;
import com.productcatalog.model.State;

@Service
public class AddressService {
	@Autowired
	AddressDao addressDao;
	
	public List<Country> getCountries(){
		
		return addressDao.getCountries();
	}

	public List<State> getStatesByCountryId(Integer countryId) {
		
		return addressDao.getStatesByCountryId(countryId);
	}

	public List<City> getCitiesByStateId(Integer countryId) {
		
		return addressDao.getCitiesByStateId(countryId);
	}
	public List<Address> getAllAddress() {
		 return addressDao.getAllAddress();
			
		}
}
