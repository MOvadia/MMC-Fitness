package com.proj.restapi.settings.controller;
import com.proj.restapi.menu.service.SubscriberService;
import general.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        Subscriber subscriberInformation = subscriberService.getSubscriberById(id);
        model.addAttribute("subscriber", subscriberInformation);
        model.addAttribute("settingsForm", subscriberInformation);
        model.addAttribute("resetMessage", "User data changes reset");
        return "settings";
    }

    @PostMapping(value = "/settings/submit", params="submit")
    public String submit(Subscriber user, Model model){
        int id = subscriberService.getUserIdByEmail(user.getEmail());

        int retVal = subscriberService.updateSubscriber(user);
        if (retVal !=0){
            model.addAttribute("updateMessage", "User data changed");
        }
        else{
            model.addAttribute("errorMessage", "User data failed to change");
        }
        Subscriber subscriberInformation = subscriberService.getSubscriberById(id);
        model.addAttribute("subscriber", subscriberInformation);
        model.addAttribute("settingsForm", subscriberInformation);
        return "settings";
    }

}
