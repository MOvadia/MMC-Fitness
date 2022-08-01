package com.proj.restapi.menu.controller;

import com.proj.restapi.auth.info.LoginInformation;
import com.proj.restapi.menu.service.MenuService;
import com.proj.restapi.menu.service.SubscriberService;
import com.proj.restapi.menu.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MenuController {
    private MenuService menuService;
    @Autowired
    private SubscriberService subscriberService = new SubscriberService();

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Object> addMenu(@RequestParam int id) {
        //return null;
        return new ResponseEntity<>(menuService.getMenuById(id), HttpStatus.OK);
    }

    @GetMapping("/menu/userId={userId}")
    public String registerUser(@PathVariable int userId, Model model)
    {
        model.addAttribute("userForm", new LoginInformation());
        //TODO - need to get user data from DB
        //TODO - get from DB the userID - than get the Subscriber by UserId
        int id = userId;
        model.addAttribute("subscriber", subscriberService.getSubscriberById(id));
        model.addAttribute("gender", "Male");
        model.addAttribute("workout", WorkoutService.getWorkoutPerUserId(1));
        model.addAttribute("menu", MenuService.getMenuById(1));


        //return "mainPageTrainer";
        return "mainPageSubscriber";
    }
}
