package org.cap.dao;

import org.cap.entities.Trainee;
import java.util.*;

public interface ITraineeDao {

    void addTrainee(Trainee t);
    void deleteTrainee(int id);
    Trainee modifyTrainee(Trainee t);
    Trainee fetchTrainee(int id);
    boolean credentialsCorrect(int id, String password);

}
