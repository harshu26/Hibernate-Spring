package org.cap.service;



import org.cap.entities.Trainee;


public interface ITraineeService {

	  void addTrainee(Trainee t);
	    void deleteTrainee(int id);
	    Trainee modifyTrainee(Trainee t);
	    Trainee fetchTrainee(int id);
	   

}
