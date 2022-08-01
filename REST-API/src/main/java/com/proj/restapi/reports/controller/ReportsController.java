package com.proj.restapi.reports.controller;

import com.proj.restapi.menu.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ReportsController {

    @Autowired
    private SubscriberService subscriberService;

    @GetMapping("/reports/{userId}")
    public String alertPage(@PathVariable int userId, Model model){
        model.addAttribute("subscriber", subscriberService.getSubscriberById(userId));

        return "reportsPage";
    }
}