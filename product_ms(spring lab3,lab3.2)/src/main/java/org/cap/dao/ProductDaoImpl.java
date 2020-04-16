package org.cap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.cap.entities.Product;
import org.cap.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements IProductDao {
	
	private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
	

	@Override
	public Product addProduct(Product product) {
		 product = getEntityManager().merge(product);
	        return product;
	}

	@Override
	public Product fetchById(int id) {
		 Product product = entityManager.find(Product.class, id);
	     if(id!=product.getId()) {
	    	 throw new ProductNotFoundException("Incorrect Id!");
	     }
		 return product;
	}

	@Override
	public Product updateProduct(Product product) {
		product = entityManager.merge(product);
		return product;
	}
	
	@Override
    public List<Product> fetchAllProducts() {
        String jql = "from Product";
        TypedQuery<Product> query = entityManager.createQuery(jql, Product.class);
        List<Product> prodList = query.getResultList();
        return prodList;
    }

	 @Override
	    public boolean delete(int id) {
	        Product product = fetchById(id);
	        getEntityManager().remove(product);
	        return true;
	    }


}
