package com.proj.restapi.trainer.controller;

import com.proj.restapi.auth.info.LoginInformation;
import com.proj.restapi.menu.service.MenuService;
import com.proj.restapi.menu.service.SubscriberService;
import com.proj.restapi.menu.service.WorkoutService;
import com.proj.restapi.trainer.service.TrainerService;
import general.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TrainerController {
    private TrainerService trainerService = new TrainerService();

    @Autowired
    private SubscriberService subscriberService = new SubscriberService();

    @PostMapping(value = "/add")
    public ResponseEntity<Object> addWorkout(@RequestBody Workout workout) {
       return new ResponseEntity<>(trainerService.addWorkout(workout), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{workoutId}")
    public ResponseEntity<Object> deleteWorkout(@PathVariable int workoutId) {
        return new ResponseEntity<>(trainerService.deleteWorkout(workoutId), HttpStatus.OK);
    }

    @GetMapping("/trainer/login/{userId}")
    public String registerUser(@PathVariable int userId, Model model)
    {
        model.addAttribute("userForm", new LoginInformation());
        //TODO - need to get user data from DB
        //TODO - get from DB the userID - than get the Subscriber by UserId
        int id = userId;
        model.addAttribute("subscriber", subscriberService.getSubscriberById(id));
        model.addAttribute("workout", trainerService.getAllWorkouts());
        return "mainPageTrainer";
    }
}
