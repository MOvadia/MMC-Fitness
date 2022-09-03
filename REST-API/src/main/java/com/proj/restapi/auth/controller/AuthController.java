package com.proj.restapi.auth.controller;

import com.proj.restapi.auth.info.LoginInformation;
import com.proj.restapi.auth.info.SubscriberInformation;
import com.proj.restapi.menu.service.RegistrationService;
import com.proj.restapi.menu.service.SubscriberService;
import general.User;
import general.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static general.UserManager.*;

@Controller
public class AuthController {

    UserManager m_userManager = null;
    @Autowired
    private RegistrationService registrationService = new RegistrationService();
    @GetMapping("/")
    public String start(Model model){
        model.addAttribute("userForm", new LoginInformation());
        //model.addAttribute("errorMsg","check");
        return "index";
    }

    @PostMapping(value = "/login", params="login")
    public String login(RedirectAttributes attributes, LoginInformation user, Model model) {
        if (!registrationService.isUserExist(user.getEmail(),user.getPassword(), user.getType())) {
            model.addAttribute("userForm", new LoginInformation());
            model.addAttribute("errorMessage", "Your credentials are incorrect");
            return "index";
        }
        int id = registrationService.getUserIdByEmail(user.getEmail());

            if (m_userManager.getUsersSet() == null) {
                m_userManager = new UserManager();
            }
        User userType= new User(registrationService.getFirstNameByEmail(user.getEmail()), registrationService.getLastNameByEmail(user.getEmail()), user.getType(), id);
        m_userManager.addUser(userType);
        if(user.getType().equals("Subscriber"))
        {
            return "redirect:/menu/userId=" + id;
        }
        else if(user.getType().equals("Trainer"))
        {
            return "redirect:/trainer/login/userId=" + id;
        }
        return "redirect:/nutritionist/login/userId=" + id;
        //model.addAttribute("userForm", new LoginInformation());
        //TODO - if the user already registered move to menu
        //TODO - else need to add error
    }

    @PostMapping(value = "/login", params="signin")
    public String register(@ModelAttribute LoginInformation user, Model model){
        model.addAttribute("registrationForm", new SubscriberInformation());
        //TODO - move to signup page
        return "registrationPage";
    }

    @PostMapping(value = "/registration", params="cancel")
    public String cancel(SubscriberInformation user, Model model){
        model.addAttribute("userForm", new LoginInformation());
        return "index";
    }

    @PostMapping(value = "/registration", params="submit")
    public String submit(SubscriberInformation user, Model model){
        int val = registrationService.createUser(user);
        model.addAttribute("userForm", new LoginInformation());
        return "redirect:/";
    }

}
