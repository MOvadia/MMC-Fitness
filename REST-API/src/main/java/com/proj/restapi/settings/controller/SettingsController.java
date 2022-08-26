package com.proj.restapi.settings.controller;

import com.proj.restapi.auth.info.LoginInformation;
import com.proj.restapi.auth.info.SubscriberInformation;
import com.proj.restapi.menu.service.SubscriberService;
import general.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SettingsController {
    @Autowired
    private SubscriberService subscriberService;

    @GetMapping("/settings/userId={userId}")
    public String SettingsPage(@PathVariable int userId, Model model){
        Subscriber subscriberInformation = subscriberService.getSubscriberById(userId);
        model.addAttribute("subscriber", subscriberInformation);
        model.addAttribute("settingsForm", subscriberInformation);

        return "settings";
    }

    @PostMapping(value = "/settings", params="cancel")
    public String registration(SubscriberInformation user, Model model){
        model.addAttribute("userForm", new LoginInformation());
        return "index";
    }

    @PostMapping(value = "/settings/submit", params="submit")
    public String submit(Subscriber user, Model model){
        //int val = registrationService.createUser(user);
       // model.addAttribute("userForm", new LoginInformation());
        return "settings";
    }

}
