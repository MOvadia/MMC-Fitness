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

    @PostMapping(value = "/settings/submit", params="cancel")
    public String registration(Subscriber user, Model model){
        int id = subscriberService.getUserIdByEmail(user.getEmail());
        return "redirect:/menu/userId=" + id;
    }

    @PostMapping(value = "/settings/submit", params="submit")
    public String submit(Subscriber user, Model model){
        int retVal = subscriberService.updateSubscriber(user);
        return "redirect:/menu/userId=" + user.getUserId();
    }

}
