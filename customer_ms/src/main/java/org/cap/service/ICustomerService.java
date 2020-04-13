package org.cap.service;

import org.cap.entities.Customer;

public interface ICustomerService {

	Customer registerCustomer(Customer customer);
	Customer fetchById(int id);
	Customer updateCustomer(Customer customer);
}
