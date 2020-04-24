package com.lab.app;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	@Value("${id}")
	private int employeeId;
	
	@Value("${name}")
	private String employeeName;
	
	@Value("${salary}")
	private double salary;
	
	@Value("${bu}")
	private String unit;
	
	@Value("${age}")
	private int age;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
//	public void display() {
	//	System.out.println("Id :"+employeeId+" "+"Name:"+employeeName+" "+"Salary:"+salary+" "+"B Unit:"+unit+" "+"Age:"+age);
	//}
	
	
	
}
