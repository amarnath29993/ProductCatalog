package com.productcatalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcatalog.dao.CustomerDao;
import com.productcatalog.model.Address;
import com.productcatalog.model.Customer;

@Service
public class CustomerService {
	@Autowired
	CustomerDao dao;

	/*public void registerCustomer(Customer customer) {

		 dao.registerCustomer(customer);
	}

	public List<Customer> getAllcustomers() {

		return dao.customerlist();
	}

	public void deleteCustomer(Integer id) {

		dao.deleteCustomer(id);
	}

	public Customer getCustomerById(Integer id) {
		return dao.getCustomerById(id);
	}

	public void customerUpdate(Customer customer) {
		dao.customerUpdate(customer);
	}
*/
	
	public void registerCustomer(Customer customer) {
		dao.registerCustomer(customer);
	}
	public List<Customer>getCustomers(){
		return dao.getCustomers();
	}
	public void saveAddress(Address address) {
		dao.saveAddress(address);
	}
}
