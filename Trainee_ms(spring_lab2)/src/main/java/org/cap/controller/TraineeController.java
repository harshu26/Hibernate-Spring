package org.cap.controller;

import org.cap.entities.Trainee;
import org.cap.service.ITraineeService;
import org.cap.session.SessionDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

@Controller
public class TraineeController {

    private ITraineeService traineeService;

    public ITraineeService getTraineeService(){
        return traineeService;
    }
    @Autowired
    public void setTraineeService(ITraineeService service){
        this.traineeService=service;
    }
    
    @Autowired
    private SessionDetails sessionDetails;   
    
   
    
    @GetMapping("/processlogin")
    public ModelAndView login(@RequestParam("id")int id , @RequestParam("password") String password){
        boolean correct=traineeService.credentialsCorrect(id,password);
        if(!correct){
         return new ModelAndView("/login");
        }
        sessionDetails.setId(id);
        ModelAndView modelAndView= new ModelAndView("traineeHome");
        return modelAndView;
    }
    
    @GetMapping("/fetch")
    public ModelAndView fetchPage() {
    	 int id=sessionDetails.getId();
         if(id==-1){
          return new ModelAndView("/login");
         }
        return new ModelAndView("findtrainee");
    }
    @GetMapping("/processfindtrainee")	//fetching trainee by id.
    public ModelAndView traineeDetails(@RequestParam("traineeid")int traineeId) {
        Trainee trainee= traineeService.fetchTrainee(traineeId);
        return new ModelAndView("traineedetails", "trainee", trainee);
    }


    @GetMapping("/register")
    public ModelAndView registerPage() {
    	int id=sessionDetails.getId();
        if(id==-1){
         return new ModelAndView("/login");
        }
        return new ModelAndView("traineeregister");
    }
    @GetMapping("/processregister")	//adding trainee.
    public ModelAndView registerTrainee(@RequestParam("traineeid") int traineeId,
                                         @RequestParam("traineename") String traineeName, @RequestParam("traineelocation")String location)
    	{
        Trainee trainee=new Trainee(traineeId,traineeName,location);
        traineeService.addTrainee(trainee);
        return new ModelAndView("traineedetails",  "trainee", trainee);
    }
    
    
    @GetMapping("/update")
    public ModelAndView updatePage() {
    	int id=sessionDetails.getId();
        if(id==-1){
         return new ModelAndView("/login");
        }
        return new ModelAndView("updatetrainee");
    }
    @GetMapping("/processupdate") //modifying trainee.
    public ModelAndView updateTrainee(@RequestParam("traineeid") int traineeId,
                                         @RequestParam("traineename") String traineeName, @RequestParam("traineelocation")String location)
    {
    	Trainee trainee=new Trainee();
        trainee.setId(traineeId);
        trainee.setName(traineeName);
        trainee.setLocation(location);
        traineeService.modifyTrainee(trainee);
    	return new ModelAndView("traineedetails",  "trainee", trainee);
    }

    @GetMapping("/delete")
    public ModelAndView deletePage() {
    	 int id=sessionDetails.getId();
         if(id==-1){
          return new ModelAndView("/login");
         }
        return new ModelAndView("deletetrainee");
    }
    @GetMapping("/processdelete") //removing trainee.
    public ModelAndView deleteTrainee(@RequestParam("traineeid")int traineeId) {
    	getTraineeService().deleteTrainee(traineeId);
    	return new ModelAndView("traineeHome");
    }
    
     
    @GetMapping("/")
    public ModelAndView home(){
        return new ModelAndView("traineeHome");
    }

    @GetMapping("/logout")
    public ModelAndView logout(){
        sessionDetails.setId(-1);
        return new ModelAndView("/login");
    }


}
