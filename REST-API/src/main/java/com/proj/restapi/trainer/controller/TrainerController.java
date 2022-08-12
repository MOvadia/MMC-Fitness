package com.proj.restapi.trainer.controller;

import com.proj.restapi.auth.info.LoginInformation;
import com.proj.restapi.auth.info.WorkoutInformation;
import com.proj.restapi.trainer.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TrainerController {
    @Autowired
    private TrainerService trainerService = new TrainerService();

    @PostMapping(value = "/workout/add")
    public void addWorkout(Model model, WorkoutInformation workoutInfo) {
        model.addAttribute("workoutForm", workoutInfo);
        trainerService.addWorkout(workoutInfo);


    }

    @DeleteMapping(value = "/{workoutId}")
    public ResponseEntity<Object> deleteWorkout(@PathVariable int workoutId) {
        return new ResponseEntity<>(trainerService.deleteWorkout(workoutId), HttpStatus.OK);
    }

    @GetMapping("/trainer/login/userId={userId}")
    public String registerUser(@PathVariable int userId, Model model)
    {
        model.addAttribute("userForm", new LoginInformation());
        //TODO - need to get user data from DB
        //TODO - get from DB the userID - than get the trainer by UserId
        int id = userId;
        model.addAttribute("trainer", trainerService.getTrainerId(id));
        model.addAttribute("workout", trainerService.getAllWorkouts());
        model.addAttribute("gender", "Male");
     //   model.addAttribute("workout", WorkoutService.getWorkoutPerUserId(1));
        return "mainPageTrainer";
    }
}
