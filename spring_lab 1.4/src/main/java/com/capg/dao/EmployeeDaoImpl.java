package com.capg.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.capg.entities.Employee;

@Component
public class EmployeeDaoImpl implements IEmployeeDao{

	private Map<Integer,Employee>store=new HashMap<>();
	
	 public EmployeeDaoImpl(){
	        store.put(100,new Employee(100,"Rama",12345.67));
	        store.put(101,new Employee(101,"Vijay",2315.66));
	    }
	 
	 @Override
	 public Employee fetchById(int id) {
		 Employee employee = null;
		 
		  employee=store.get(id);
		
		 return employee;
	 }
	 


}
