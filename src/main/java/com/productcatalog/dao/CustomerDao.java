package com.productcatalog.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.productcatalog.model.Address;
import com.productcatalog.model.Customer;
import com.productcatalog.repo.AddressRepo;
import com.productcatalog.repo.CustomerRepo;

@Repository
public class CustomerDao {
	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	AddressRepo addRepo;

	/*public Customer saveCustomer(Customer customer) {

		return customerRepo.save(customer);
	}

	public List<Customer> customerlist() {

		return customerRepo.findAll();
	}

	public void deleteCustomer(Integer id) {
		customerRepo.deleteById(id);
	}

	public Customer getCustomerById(Integer id) {
		return customerRepo.findById(id).get();
	}

	public void customerUpdate(Customer customer) {
		customerRepo.save(customer);
	}
	public void registerCustomer(Customer customer) {
		customerRepo.save(customer);
	}*/
	
	public void registerCustomer(Customer customer) {
		customerRepo.save(customer);
	}
	public List<Customer>getCustomers(){
		return customerRepo.findAll();
	}
	public void saveAddress(Address address) {
		addRepo.save(address);
		
	}

}
