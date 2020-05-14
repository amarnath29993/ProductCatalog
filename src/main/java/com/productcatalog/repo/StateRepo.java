package com.productcatalog.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productcatalog.model.Country;
import com.productcatalog.model.State;

public interface StateRepo extends JpaRepository<State, Integer> {
	List<State> findByCountry(Country country);

}
