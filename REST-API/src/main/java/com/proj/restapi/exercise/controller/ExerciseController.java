package com.proj.restapi.exercise.controller;

import com.proj.restapi.menu.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExerciseController {
    @Autowired
    private SubscriberService subscriberService;


}
