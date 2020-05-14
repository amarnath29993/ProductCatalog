package com.productcatalog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productcatalog.model.Country;

public interface CountryRepo extends JpaRepository<Country, Integer> {
	/*List<Country> findByCountryId(Integer countryId);
	List<Country> findByName(String name);*/

}
