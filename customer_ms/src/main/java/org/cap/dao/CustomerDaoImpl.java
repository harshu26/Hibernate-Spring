package org.cap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.cap.entities.Customer;
import org.cap.exceptions.CustomerNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl implements ICustomerDao {
	
	private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
	

	@Override
	public Customer registerCustomer(Customer customer) {
		 customer = getEntityManager().merge(customer);
	        return customer;
	}

	@Override
	public Customer fetchById(int id) {
		 Customer customer = entityManager.find(Customer.class, id);
	     if(id!=customer.getcId()) {
	    	 throw new CustomerNotFoundException("Incorrect Id!");
	     }
		 return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		customer = entityManager.merge(customer);
		return customer;
	}
	
	@Override
    public List<Customer> fetchAllCustomers() {
        String jql = "from Customer";
        TypedQuery<Customer> query = entityManager.createQuery(jql, Customer.class);
        List<Customer> custList = query.getResultList();
        return custList;
    }

	 @Override
	    public boolean delete(int id) {
	        Customer customer = fetchById(id);
	        getEntityManager().remove(customer);
	        return true;
	    }


}
