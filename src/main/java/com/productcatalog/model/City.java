package com.productcatalog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cityId;
	private String name;
	private Integer stateId;
	public City() {
		super();
	}
	public City(Integer cityId, String name, Integer stateId) {
		super();
		this.cityId = cityId;
		this.name = name;
		this.stateId = stateId;
	}
	
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", name=" + name + ", stateId=" + stateId + "]";
	}
	
}
