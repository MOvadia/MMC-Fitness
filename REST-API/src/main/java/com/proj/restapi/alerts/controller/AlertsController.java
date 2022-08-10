package com.proj.restapi.alerts.controller;

import com.proj.restapi.auth.info.LoginInformation;
import com.proj.restapi.menu.service.SubscriberService;
import com.proj.restapi.menu.service.WorkoutService;
import general.Meal;
import general.SubscriberToMenu;
import general.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;

@Controller
public class AlertsController {
    @Autowired
    private SubscriberService subscriberService;
    @GetMapping("/alert/userId={userId}")
    public String alertPage(@PathVariable int userId, Model model){
        List<String> usersList = UserManager.getUsersSet();
        model.addAttribute("users", usersList);
        model.addAttribute("subscriber", subscriberService.getSubscriberById(userId));

        return "alertsPage";
    }

   /* @GetMapping("/alert/userslist")
    public String userList(Model model)
    {
        List<String> usersList = UserManager.getUsersSet();
        model.addAttribute("users", usersList);
        return "alertsPage";
    }
*/
}
