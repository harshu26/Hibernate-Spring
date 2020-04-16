package org.cap.service;

import java.util.List;

import javax.transaction.Transactional;

import org.cap.dao.IProductDao;
import org.cap.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {


    private IProductDao productDao;

    public IProductDao getProductDao() {
        return productDao;
    }

    @Autowired
    public void setProductDao(IProductDao dao) {
        this.productDao = dao;
    }

	
	
	@Override
	public Product addProduct(Product product) {
		Product prod = productDao.addProduct(product);
		return prod;
	}

	@Override
	public Product fetchById(int id) {
		Product prod = productDao.fetchById(id);
		return prod;
	}

	@Override
	public Product updateProduct(Product product) {
		Product prod = productDao.updateProduct(product);
		return prod;
	}
	
	@Override
	public List<Product> fetchAllProducts(){
		List<Product>list = productDao.fetchAllProducts();
		return list;
	}
	
	@Override
	public boolean delete(int id) {
		boolean result=productDao.delete(id);
		return result;
	}
	

}
