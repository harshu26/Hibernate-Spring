package org.cap.entities;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue
	private int cId;
	private String cName;
	
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	

}
