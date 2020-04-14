package org.cap.entities;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "Customers")
public class Customer {
	
	
	@Id
	@GeneratedValue
	private int cId;
	
	//@Column(name = "custname")
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
	

	@Override
	public int hashCode() {
	return Objects.hash(cId);
	}
	@Override
	public boolean equals(Object obj) {
		 if (this == obj) {
	            return true;
	        }
	        if (obj == null || getClass() != obj.getClass()) {
	            return false;
	        }
	        Customer customer = (Customer) obj;
	        return cId == customer.cId;
	}
}
