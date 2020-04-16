package org.cap.service;

import java.util.List;

import org.cap.entities.Product;

public interface IProductService {

	Product addProduct(Product product);
	Product fetchById(int id);
	Product updateProduct(Product product);
	List<Product> fetchAllProducts();
	boolean delete(int id);
}
