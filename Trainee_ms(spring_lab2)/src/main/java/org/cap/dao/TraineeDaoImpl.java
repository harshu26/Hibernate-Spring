package org.cap.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.cap.entities.Trainee;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class TraineeDaoImpl implements ITraineeDao{
	
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
	
    private Map<Integer,Trainee>admin = new HashMap<>();
    
    public TraineeDaoImpl() {
    Trainee admin1 = new Trainee();
    admin1.setId(1);
    admin1.setName("Harsh");
    admin1.setPassword("abcd");
    admin1.setLocation("bhopal");
    admin.put(1,admin1);
    }
    
	@Override
	public void addTrainee(Trainee t) {
	 getEntityManager().merge(t);
	        		
	}

	@Override
	public void deleteTrainee(int id) {
	     Trainee trainee = fetchTrainee(id);
	     getEntityManager().remove(trainee);
    	}

	@Override
	public Trainee modifyTrainee(Trainee t) {
    		t = entityManager.merge(t);
		return t;
	}

	@Override
	public Trainee fetchTrainee(int id) {
	   Trainee trainee = entityManager.find(Trainee.class, id);
		return trainee;
	}


    @Override
    public boolean credentialsCorrect(int id, String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        Trainee trainee = admin.get(id);
        if (trainee == null) {
            return false;
        }
        return trainee.getPassword().equals(password);
    }

  
}
