package org.cap.dao;

import java.util.List;

import org.cap.entities.Product;

public interface IProductDao {
	Product addProduct(Product product);
	Product fetchById(int id);
	Product updateProduct(Product product);
	
	List<Product> fetchAllProducts();
	boolean delete(int id);
}
