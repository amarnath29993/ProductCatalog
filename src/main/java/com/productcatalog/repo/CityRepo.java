package com.productcatalog.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productcatalog.model.City;
import com.productcatalog.model.State;

public interface CityRepo extends JpaRepository<City, Integer> {
	List<City> findByState(State state);

}
