package com.proj.restapi.menu.controller;

import com.proj.restapi.auth.info.LoginInformation;
import com.proj.restapi.menu.service.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("menu")
public class MenuController {
    private MenuService menuService;


    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Object> addMenu(@RequestParam String id) {
        //return null;
        return new ResponseEntity<>(menuService.getMenuById(id), HttpStatus.OK);
    }

    @PostMapping("/menu")
    public String registerUser(@ModelAttribute LoginInformation user, Model model)
    {
        System.out.println(user.toString());
        model.addAttribute("userForm", new LoginInformation());
        //TODO - need to get user data from DB

        model.addAttribute("username", user.getUsername());
        model.addAttribute("age", "27");
        model.addAttribute("gender", "Male");
        model.addAttribute("weight", "98");
        model.addAttribute("height", "1.78");
        model.addAttribute("BMI", "98%");
        model.addAttribute("fatPercentage", "25%");
        model.addAttribute("weightGoal", "85");
        return "mainPageSubscriber";
    }
}
