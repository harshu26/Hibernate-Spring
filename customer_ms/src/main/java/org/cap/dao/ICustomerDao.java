package org.cap.dao;

import org.cap.entities.Customer;

public interface ICustomerDao {
	Customer registerCustomer(Customer customer);
	Customer fetchById(int id);
	Customer updateCustomer(Customer customer);
	
}
