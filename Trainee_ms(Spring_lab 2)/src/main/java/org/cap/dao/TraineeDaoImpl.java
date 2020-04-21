package org.cap.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.cap.entities.Trainee;
import org.springframework.stereotype.Repository;

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


  
  
}
