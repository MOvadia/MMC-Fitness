package com.proj.restapi.auth.controller;

import com.proj.restapi.auth.info.LoginInformation;
import com.proj.restapi.auth.info.SubscriberInformation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {
    @GetMapping("/")
    public String start(Model model){
        model.addAttribute("userForm", new LoginInformation());
        return "index";
    }

    @PostMapping(value = "/register", params="login")
    public String login(RedirectAttributes attributes,LoginInformation user,  Model model){
        //model.addAttribute("userForm", new LoginInformation());
        //TODO - if the user already registered move to menu
        //TODO - else need to add error

        return "redirect:/menu/1";
    }

    @PostMapping(value = "/register", params="signin")
    public String register(@ModelAttribute LoginInformation user, Model model){
        model.addAttribute("registrationForm", new SubscriberInformation());
        //TODO - move to signup page
        return "registrationPage";
    }

    @PostMapping(value = "/registration", params="cancel")
    public String registration(SubscriberInformation user, Model model){
        model.addAttribute("userForm", new LoginInformation());
        return "index";
    }

    @PostMapping(value = "/registration", params="submit")
    public String submit(SubscriberInformation user, Model model){
        model.addAttribute("userForm", new LoginInformation());
        return "redirect:/";
    }

}
