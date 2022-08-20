package com.proj.restapi.reports.controller;

import com.proj.restapi.menu.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportsController {

    @Autowired
    private SubscriberService subscriberService;

    @GetMapping("/report/userId={userId}")
    public String reportPage(@PathVariable int userId, Model model){
        model.addAttribute("subscriber", subscriberService.getSubscriberById(userId));
        Map<String, Double> graphData = new TreeMap<>();
        //TODO: pull from the DB
        graphData.put("week 1", 84.0);
        graphData.put("week 2", 84.2);
        graphData.put("week 3", 83.8);
        graphData.put("week 4", 83.3);

        model.addAttribute("chartData", graphData);


        return "reportsPage";
    }
}