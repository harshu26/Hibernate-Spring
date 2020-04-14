package org.cap.dao;

import java.util.List;

import org.cap.entities.Customer;

public interface ICustomerDao {
	Customer registerCustomer(Customer customer);
	Customer fetchById(int id);
	Customer updateCustomer(Customer customer);
	
	List<Customer> fetchAllCustomers();
	boolean delete(int id);
}
