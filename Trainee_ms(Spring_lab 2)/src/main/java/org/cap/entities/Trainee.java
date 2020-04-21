package org.cap.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trainees")
public class Trainee {

	@Id
    private int id;
    private String name;
    private String location;
   
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getLocation() {
    	return location;
    }
    
    public void setLocation(String location) {
    	this.location=location;
    }
    
    
	public Trainee(){

    }
	public Trainee(int id, String name, String location) {
		this.id = id;
		this.name = name;
		this.location = location;
	}



}
