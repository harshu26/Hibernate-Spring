package org.cap.service;

import java.util.List;

import org.cap.entities.Trainee;
import org.springframework.stereotype.Component;

public interface ITraineeService {

	  void addTrainee(Trainee t);
	    void deleteTrainee(int id);
	    Trainee modifyTrainee(Trainee t);
	    Trainee fetchTrainee(int id);
	    boolean credentialsCorrect(int id, String password);

}
