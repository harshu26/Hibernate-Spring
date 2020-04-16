package org.cap.controller;

import java.util.List;

import org.cap.config.MyWebMVCConfig;
import org.cap.dto.CustomerDto;
import org.cap.entities.Customer;
import org.cap.exceptions.CustomerNotFoundException;
import org.cap.service.ICustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestController {
	 private static Logger Log = LoggerFactory.getLogger(CustomerRestController.class);
	@Autowired
	private ICustomerService service;
	
    Customer convert(CustomerDto dto) {
        Customer customer = new Customer();
        customer.setcName(dto.getcName());
        return customer;
    }
    
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> handleCustomerNotFound(CustomerNotFoundException exception) {
        Log.error("handling exception", exception);
        String exceptionMsg=exception.getMessage();
        ResponseEntity<String> response = new ResponseEntity<>(exceptionMsg,HttpStatus.NOT_FOUND);
        return response;
    }
    
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleAllExceptions(Throwable exception) {
        Log.error("handleAllExceptions", exception);
        String msg="something went wrong";
        ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
        return response;
    }
    
    @PostMapping("/customers/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody CustomerDto dto) {
        Customer customer = convert(dto);
        customer = service.registerCustomer(customer);
        ResponseEntity<Customer> response = new ResponseEntity<>(customer, HttpStatus.OK);
        return response;
    }
    
    @GetMapping("/customers/find/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") int id) {
        Customer customer = service.fetchById(id);
        if(customer==null){
            ResponseEntity<Customer> response= new ResponseEntity<>(HttpStatus.NOT_FOUND);
           return response;
        }
        ResponseEntity<Customer> response = new ResponseEntity<>(customer, HttpStatus.OK);
        return response;
    }
    
    
    @PutMapping("/customers/update/{id}")
    public ResponseEntity<Customer>updateEmployee(@RequestBody CustomerDto dto ,@PathVariable("id")int id){
        Customer customer=convert(dto);
        customer.setcId(id);
        customer = service.updateCustomer(customer);
        ResponseEntity<Customer>response=new ResponseEntity<>(customer,HttpStatus.OK);
        return response;
    }
    
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> fetchAll(){
        List<Customer> customers = service.fetchAllCustomers();
        ResponseEntity<List<Customer>> response = new ResponseEntity<>(customers, HttpStatus.OK);
        return response;
    }

    @DeleteMapping("/customers/delete/{id}")
    public ResponseEntity<Boolean>deleteCustomer(@PathVariable int id){
       boolean result= service.delete(id);
       ResponseEntity<Boolean>response=new ResponseEntity<>(result, HttpStatus.OK);
       return response;
    }

    
    
}
