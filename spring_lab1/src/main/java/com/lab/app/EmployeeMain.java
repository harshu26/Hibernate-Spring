package com.lab.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;

import com.lab.app.JavaConfig;

public class EmployeeMain {
	public static void main(String[] args) {
	 AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	 Class configurationClass=JavaConfig.class;
     context.register(configurationClass);
     context.refresh();

     EmployeeDetails employee = context.getBean(EmployeeDetails.class);
     employee.details();
	}

}