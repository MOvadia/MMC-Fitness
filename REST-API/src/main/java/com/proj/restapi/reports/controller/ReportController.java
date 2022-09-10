package com.proj.restapi.reports.controller;
import com.proj.restapi.reports.service.ReportsService;
import com.proj.restapi.menu.service.SubscriberService;
import com.proj.restapi.trainer.service.TrainerService;
import general.SystemEvents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.DecimalFormat;
import java.util.*;

@Controller
public class ReportController {
    @Autowired
    private SubscriberService subscriberService;
    @Autowired
    private ReportsService reportsService = new ReportsService();

    @GetMapping("/report/userId={userId}")
    public String reportPage(@PathVariable int userId, Model model){
        double lastweek,total;
        model.addAttribute("subscriber", subscriberService.getSubscriberById(userId));
        LinkedHashMap<String, Double> graphData = new LinkedHashMap<>();
        List<SystemEvents> sysEvent = reportsService.getSysEvents(userId);
        Collections.sort(sysEvent, new SystemEvents());
        for (SystemEvents event: sysEvent) {
            graphData.put("week " + event.getWeek(),event.getCurrentWeight());
        }

         total = sysEvent.get(sysEvent.size()-1).getCurrentWeight() - sysEvent.get(0).getCurrentWeight();

        if(sysEvent.size()<2){
            lastweek = total;
        }
        else{
            lastweek = sysEvent.get(sysEvent.size()-1).getCurrentWeight() - sysEvent.get(sysEvent.size()-2).getCurrentWeight();
        }

        lastweek =Double.parseDouble(new DecimalFormat("##.###").format(lastweek));
        total =Double.parseDouble(new DecimalFormat("##.###").format(total));

        model.addAttribute("chartData", graphData);
        model.addAttribute("lastweek", lastweek);
        model.addAttribute("total", total);

        return "reportsPage";
    }
}