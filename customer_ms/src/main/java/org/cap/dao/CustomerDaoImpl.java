package org.cap.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cap.entities.Customer;
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
	        return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		customer = entityManager.merge(customer);
		return customer;
	}

}
