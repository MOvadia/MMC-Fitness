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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class AlertsController {
    @Autowired
    private SubscriberService subscriberService;
    ChatManager chatManager = new ChatManager();


    @RequestMapping(value = "/alert/userslist", method = POST)
    @ResponseBody
    public List<User> postUsers(Model model) {
        List<User> usersList = new ArrayList<>();
        usersList.addAll(UserManager.getUsersSet());
        model.addAttribute("usersList", usersList);
        return usersList;
    }

    @GetMapping("/alert/userId={userId}")
    public String alertPage(@PathVariable int userId, Model model){
        List<User> usersList = new ArrayList<>();
        usersList.addAll(UserManager.getUsersSet());
        User myuser = usersList.stream().filter(users -> users.getUserId() == userId).collect(Collectors.toList()).get(0);
        usersList.remove(myuser);
        model.addAttribute("users", usersList);
        model.addAttribute("subscriber", subscriberService.getUserById(userId));
       // model.addAttribute("id", userId);

        return "alertsPage";
    }

    @RequestMapping(value = "/alert/chat", method = GET)
    @ResponseBody
    public List<Chat> chatMassages(@RequestParam int userId,@RequestParam int chatId)
    {
        chatManager.addChatString("",userId,chatId);
        List<Chat> chatList = chatManager.getChatEntries(userId,chatId);

        return chatList;
    }

    @RequestMapping(value = "/alert/send", method = GET)
    @ResponseBody
    public List<Chat> sendMassage(@RequestParam int userId,@RequestParam int chatId,@RequestParam String chatString)
    {
        chatManager.addChatString(chatString,userId,chatId);
        List<Chat> chatList = chatManager.getChatEntries(userId,chatId);

        return chatList;
    }

    @RequestMapping(value = "/alert/chatString", method = GET)
    @ResponseBody
    public List<Chat> getMassages(@RequestParam int userId,@RequestParam int chatId)
    {
        List<Chat> chatList = chatManager.getChatEntries(userId,chatId);

        return chatList;
    }

}
