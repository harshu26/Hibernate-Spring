package org.cap.service;

import java.util.List;

import javax.transaction.Transactional;

import org.cap.dao.ICustomerDao;
import org.cap.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {


    private ICustomerDao customerDao;

    public ICustomerDao getCustomerDao() {
        return customerDao;
    }

    @Autowired
    public void setCustomerDao(ICustomerDao dao) {
        this.customerDao = dao;
    }

	
	
	@Override
	public Customer registerCustomer(Customer customer) {
		Customer cust = customerDao.registerCustomer(customer);
		return cust;
	}

	@Override
	public Customer fetchById(int id) {
		Customer cust = customerDao.fetchById(id);
		return cust;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer cust = customerDao.updateCustomer(customer);
		return cust;
	}
	
	@Override
	public List<Customer> fetchAllCustomers(){
		List<Customer>list = customerDao.fetchAllCustomers();
		return list;
	}
	
	@Override
	public boolean delete(int id) {
		boolean result=customerDao.delete(id);
		return result;
	}
	

}
