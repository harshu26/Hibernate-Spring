package com.lab.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


import com.lab.app.JavaConfig;

public class EmployeeMain {
	public static void main(String[] args) {
	 AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	 Class configurationClass=JavaConfig.class;
     context.register(configurationClass);
     context.refresh();
     
     SBU sbu=context.getBean(SBU.class);
     sbu.displaySbu();
     
     List<Employee>empList = sbu.getEmpList();
     EmployeeMain mainO = new EmployeeMain();
     System.out.println("Employee Details:");
     mainO.displayEmployee(empList);
     
    // sbu.displayEmployee();
	}

	public void displayEmployee(List<Employee>empList) {
		for(Employee e : empList) {
			System.out.println("Name :"+e.getEmployeeName()+" "+"Id:"+e.getEmployeeId()+" "+"Age:"+e.getAge()+" "+"Business Unit:"+e.getUnit()+" "+"Salary:"+e.getSalary());
		}
	}
	
	

}