package com.proj.restapi.workout.controller;

import com.proj.restapi.menu.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WorkoutController {
    @Autowired
    private SubscriberService subscriberService;

    @GetMapping("/workout/userId={userId}/workout={workoutId}")
    public String workoutPage(@PathVariable int userId, @PathVariable int workoutId, Model model){
        model.addAttribute("subscriber", subscriberService.getSubscriberById(userId));
        return "workoutSubscriber";
    }
}
