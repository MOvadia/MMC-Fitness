package com.proj.restapi.alerts.controller;

import com.proj.restapi.auth.info.LoginInformation;
import com.proj.restapi.menu.service.SubscriberService;
import com.proj.restapi.menu.service.WorkoutService;
import general.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

@Controller
public class AlertsController {
    @Autowired
    private SubscriberService subscriberService;
    ChatManager chatManager = new ChatManager();
    @GetMapping("/alert/userId={userId}")
    public String alertPage(@PathVariable int userId, Model model){
        List<User> usersList = UserManager.getUsersSet();
        model.addAttribute("users", usersList);
        model.addAttribute("subscriber", subscriberService.getUserById(userId));

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

    @PostMapping(value = "/alert/userId={userId}&chat={chatId}", params="chat")
    public String chatMasseges(@PathVariable int userId,@PathVariable int chatId, Model model)
    {
        int chatManagerVersion = 0;
//        int chatNum = Integer.parseInt(chatId);
        List<Chat> chatEntries;
    //        chatManagerVersion = chatManager.getVersion();
           // chatEntries = chatManager.getChatEntries(chatVersion);
        chatManager.addChatString("hello", "check");
        List<Chat> chatList = chatManager.getChatEntries(1);
        model.addAttribute("chatStrings", chatList);
        model.addAttribute("subscriber", subscriberService.getUserById(userId));
        List<User> usersList = UserManager.getUsersSet();
        model.addAttribute("users", usersList);
        // log and create the response json string
       // ChatAndVersion cav = new ChatAndVersion(chatEntries, chatManagerVersion);
       // logServerMessage("Server Chat version: " + chatManagerVersion + ", User '" + username + "' Chat version: " + chatVersion);
        //logServerMessage(jsonResponse);


        return "alertsPage";
    }
}
