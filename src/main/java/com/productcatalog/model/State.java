package com.productcatalog.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class State {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer stateId;
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="stateId",referencedColumnName="stateId")
	private Set<City> cities=new HashSet<>();

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {
		return "State [stateId=" + stateId + ", name=" + name + ", cities=" + cities + "]";
	}
	

}
