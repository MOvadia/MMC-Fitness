package com.proj.restapi.menu.controller;

import com.proj.restapi.auth.info.LoginInformation;
import com.proj.restapi.menu.service.MenuService;
import com.proj.restapi.menu.service.SubscriberService;
import com.proj.restapi.menu.service.WorkoutService;
import general.Subscriber;
import general.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MenuController {
    @Autowired
    private SubscriberService subscriberService = new SubscriberService();
    @Autowired
    private MenuService menuService;

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Object> addMenu(@RequestParam int id) {
        //return null;
        return new ResponseEntity<>(menuService.getMenuById(id), HttpStatus.OK);
    }

    @GetMapping("/menu/userId={userId}")
    public String registerUser(@PathVariable int userId, Model model)
    {
        int id = userId;
        Subscriber subscriber =  subscriberService.getSubscriberById(id);
        model.addAttribute("userForm", new LoginInformation());
        //TODO - need to get user data from DB
        //TODO - get from DB the userID - than get the Subscriber by UserId
        //TODO - menu for each user
        model.addAttribute("subscriber", subscriberService.getSubscriberById(id));
        model.addAttribute("gender", subscriber.getGender());
        model.addAttribute("workout", WorkoutService.getWorkoutPerUserId(1));
        model.addAttribute("menu", menuService.getMenuById(userId));
        model.addAttribute("meals", menuService.getMenuMealsById(userId));


        //return "mainPageTrainer";
        return "mainPageSubscriber";
    }
}
