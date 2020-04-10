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
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer countryId;
	private String name;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="countryId",referencedColumnName="countryId")
	private Set<State> states=new HashSet<State>();
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<State> getStates() {
		return states;
	}
	public void setStates(Set<State> states) {
		this.states = states;
	}
	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", name=" + name + ", states=" + states + "]";
	}
	

	
}
