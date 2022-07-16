package com.proj.restapi.auth.controller;

import com.proj.restapi.auth.info.LoginInformation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @GetMapping("/")
    public String start(Model model){
        model.addAttribute("userForm", new LoginInformation());
        return "index";
    }


}
