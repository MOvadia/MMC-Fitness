package com.proj.restapi.workout.controller;

import com.proj.restapi.menu.service.SubscriberService;
import com.proj.restapi.trainer.service.TrainerService;
import com.proj.restapi.workout.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class WorkoutController {
    @Autowired
    private SubscriberService subscriberService;
    @Autowired
    private TrainerService trainerService;
    @Autowired
    private ExerciseService exerciseService;


    @GetMapping("/workout/userId={userId}/workout={workoutId}")
    public String workoutPage(@PathVariable int userId, @PathVariable int workoutId, Model model){
        model.addAttribute("subscriber", subscriberService.getSubscriberById(userId));
        model.addAttribute("exersize", exerciseService.getExercisesByWorkoutIdAndUserId(workoutId, userId));
        return "workoutSubscriber";
    }

    @GetMapping("/open/workout/trainer/userId={userId}/workout={workoutId}")
    public String workoutTrainerPage(@PathVariable int userId, @PathVariable int workoutId, Model model){
        model.addAttribute("trainer", trainerService.getTrainerId(userId));
        model.addAttribute("exersize", exerciseService.getExercisesByWorkoutId(workoutId));
        return "workoutTrainer";
    }

    @GetMapping("/edit/workout/trainer/userId={userId}/workout={workoutId}")
    public String workoutTrainerPageEdit(@PathVariable int userId, @PathVariable int workoutId, Model model){
        model.addAttribute("trainer", trainerService.getTrainerId(userId));
        model.addAttribute("exersize", exerciseService.getExercisesByWorkoutId(workoutId));
        return "workoutTrainer";
    }
}
