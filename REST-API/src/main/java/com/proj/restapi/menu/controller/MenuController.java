package com.proj.restapi.menu.controller;

import com.proj.restapi.RestApiApplication;
import com.proj.restapi.auth.info.LoginInformation;
import com.proj.restapi.menu.service.MenuService;
import com.proj.restapi.menu.service.SubscriberService;
import com.proj.restapi.menu.service.WorkoutService;
import general.Subscriber;
import general.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class MenuController {
    private MenuService menuService;

    @Autowired
    public JdbcTemplate jdbcTemplate;
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
        //TODO - get from DB the userID - than get the Subscriber by UserId
        int id = 123;
        model.addAttribute("subscriber", SubscriberService.getSubscriberById(id));
        model.addAttribute("gender", "Male");
        model.addAttribute("workout", WorkoutService.getWorkoutPerUserId(123));

        String sql = "SELECT * FROM test1";
        List<User> customers = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(User.class));

        customers.forEach(System.out :: println);
        return "mainPageSubscriber";
    }
}
