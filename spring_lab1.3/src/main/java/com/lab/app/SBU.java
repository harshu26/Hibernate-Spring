package com.lab.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;



public class SBU {
	@Value("${sbuId}")
	private String sbuId;
	
	@Value("${sbuName}")
	private String sbuName;
	
	@Value("${sbuHead}")
	private String sbuHead;
	
	public String getSbuId() {
		return sbuId;
	}
	public void setSbuId(String sbuId) {
		this.sbuId = sbuId;
	}
	
	public String getSbuName() {
		return sbuName;
	}
	public void setSbuName(String sbuName) {
		this.sbuName = sbuName;
	}
	public String getSbuHead() {
		return sbuHead;
	}
	public void setSbuHead(String sbuHead) {
		this.sbuHead = sbuHead;
	}
	
	private List<Employee>empList;

	public List<Employee> getEmpList() {
		return empList;
	}
	
	@Autowired
	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
		
	
	void displaySbu() {
		System.out.println("SBU Details= SBU"+"["+"sbuCode:"+sbuId+" "+"sbuHead:"+sbuHead+" "+"sbuName:"+sbuName+"]");
		}
	
	
}
