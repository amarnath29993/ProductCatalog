package com.productcatalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcatalog.dao.CustomerDao;
import com.productcatalog.model.Customer;

@Service
public class CustomerService {
	@Autowired
	CustomerDao dao;

	public Customer registerCustomer(Customer customer) {

		return dao.saveCustomer(customer);
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

}
