package org.cap.controller;

import java.util.List;

import org.cap.entities.Product;
import org.cap.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public class ProductController {

	@Autowired
	IProductService service;
	
	@GetMapping("/find")
    public ModelAndView findPage() {
        return new ModelAndView("findproduct");
    }
    @GetMapping("/processfindprod")
    public ModelAndView productDetails(@RequestParam("prodid")int prodId) {
        Product product= service.fetchById(prodId);
        return new ModelAndView("productdetails", "product", product);
    }
    
    
 @GetMapping("/register")
    public ModelAndView registerPage() {
        return new ModelAndView("productregister");
    }
    @GetMapping("/processregister")
    public ModelAndView registerProduct( @RequestParam("prodname") String prodName, @RequestParam("prodprice") double prodPrice) {
        Product product = new Product();
        product.setName(prodName);
        product.setPrice(prodPrice);
        product=service.addProduct(product);
        return new ModelAndView("productdetails",  "product", product);
    }
    
    
    @GetMapping("/update")
    public ModelAndView updatePage() {
        return new ModelAndView("updateProduct");
    }
    @GetMapping("/processupdate")
    public ModelAndView updateProduct(@RequestParam("prodid") int prodId, @RequestParam("prodname") String prodName, @RequestParam("prodprice") double prodPrice) {
       Product product = new Product();
       product.setId(prodId);
       product.setName(prodName);
       product.setPrice(prodPrice);
       product = service.updateProduct(product);
        return new ModelAndView("productdetails",  "product", product);
    }   
    
    @GetMapping("/displayall")
    public ModelAndView displayAllProducts(){
        List<Product> products=service.fetchAllProducts();
        ModelAndView modelAndView=new ModelAndView("allproducts","products",products);
        return modelAndView;
    }
    
}
