package org.cap.controller;
import org.cap.entities.Customer;
import org.cap.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

	@Autowired
	private ICustomerService service;
	
	 @GetMapping("/find")
	    public ModelAndView findPage() {
	        return new ModelAndView("findcustomer");
	    }
	    @GetMapping("/processfindcust")
	    public ModelAndView employeeDetails(@RequestParam("custid")int custId) {
	        Customer customer= service.fetchById(custId);
	        return new ModelAndView("customerdetails", "customer", customer);
	    }
	    
	    
	 @GetMapping("/register")
	    public ModelAndView registerPage() {
	        return new ModelAndView("customerregister");
	    }
	    @GetMapping("/processregister")
	    public ModelAndView registerEmployee( @RequestParam("custname") String custName) {
	        Customer customer=new Customer();
	        customer.setcName(custName);
	        customer=service.registerCustomer(customer);
	        return new ModelAndView("customerdetails",  "customer", customer);
	    }
	    
	    
	    @GetMapping("/update")
	    public ModelAndView updatePage() {
	        return new ModelAndView("updatecustomer");
	    }
	    @GetMapping("/processupdate")
	    public ModelAndView updateCustomer(@RequestParam("custid") int custId, @RequestParam("custname") String custName) {
	        Customer customer=new Customer();
		customer.setcId(custId);
	        customer.setcName(custName);
	        customer=service.updateCustomer(customer);
	        return new ModelAndView("customerdetails",  "customer", customer);
	    }   
	    
	    
   
}
