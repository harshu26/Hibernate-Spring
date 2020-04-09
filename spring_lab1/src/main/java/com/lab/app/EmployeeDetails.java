package com.lab.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDetails {
	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	@Autowired
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EmployeeDetails() {
		
	}
	public EmployeeDetails(Employee employee) {
		this.employee = employee;
	}
	 public void details(){
	        employee.display();
	    }

	
	
	
}
