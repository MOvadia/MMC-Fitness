package com.proj.restapi.menu.controller;

import com.proj.restapi.menu.service.SubscriberService;
import com.proj.restapi.menu.service.WorkoutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/MMC-Fitness")
public class WorkoutController {
    @GetMapping(value = "/workout/{userId}/{workoutId}")
    public String getWorkout(@PathVariable int userId, @PathVariable int workoutId, Model model) {
        //new ResponseEntity<>(WorkoutService.getWorkoutForUserByWorkoutId(userId, workoutId), HttpStatus.OK);
        model.addAttribute("subscriber", SubscriberService.getSubscriberById(userId));
        return "workoutSubscriber";
    }
}