package com.productcatalog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class State {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer stateId;
	private String name;
	private Integer countryId;
	public State() {
		super();
	}
	public State(Integer stateId, String name, Integer countryId) {
		super();
		this.stateId = stateId;
		this.name = name;
		this.countryId = countryId;
	}
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
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	@Override
	public String toString() {
		return "State [stateId=" + stateId + ", name=" + name + ", countryId=" + countryId + "]";
	}
	

}
