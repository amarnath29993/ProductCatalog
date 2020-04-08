package com.productcatalog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
	private String address;
	private Integer cityId;
	private Integer vendorId;
	private String pincode;
	private Integer customerId;
	private String landmark;
	private String name;
	private String contact;
	public Address() {
		super();
	}
	public Address(Integer addressId, String address, Integer cityId, Integer vendorId, String pincode,
			Integer customerId, String landmark, String name, String contact) {
		super();
		this.addressId = addressId;
		this.address = address;
		this.cityId = cityId;
		this.vendorId = vendorId;
		this.pincode = pincode;
		this.customerId = customerId;
		this.landmark = landmark;
		this.name = name;
		this.contact = contact;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getVendorId() {
		return vendorId;
	}
	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", address=" + address + ", cityId=" + cityId + ", vendorId="
				+ vendorId + ", pincode=" + pincode + ", customerId=" + customerId + ", landmark=" + landmark
				+ ", name=" + name + ", contact=" + contact + "]";
	}
	

}
