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

@Controller
public class AlertsController {
    @Autowired
    private SubscriberService subscriberService;
    ChatManager chatManager = new ChatManager();
    @GetMapping("/alert/userId={userId}")
    public String alertPage(@PathVariable int userId, Model model){
        List<User> usersList = new ArrayList<>();
        usersList.addAll(UserManager.getUsersSet());
        User myuser = usersList.stream().filter(users -> users.getUserId() == userId).collect(Collectors.toList()).get(0);
        usersList.remove(myuser);
        model.addAttribute("users", usersList);
        model.addAttribute("subscriber", subscriberService.getUserById(userId));
        model.addAttribute("massageForm", new Chat(userId, 2));

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
    public String chatMassages(@PathVariable int userId,@PathVariable int chatId, Model model)
    {
        List<User> usersList = new ArrayList<>();
        usersList.addAll(UserManager.getUsersSet());
        User myuser = usersList.stream().filter(users -> users.getUserId() == userId).collect(Collectors.toList()).get(0);
        usersList.remove(myuser);
        int chatManagerVersion = 0;
//        int chatNum = Integer.parseInt(chatId);
        List<Chat> chatEntries;
    //        chatManagerVersion = chatManager.getVersion();
           // chatEntries = chatManager.getChatEntries(chatVersion);
       /// chatManager.addChatString("Me: Hi Dor! ",userId, chatId);
    /*chatManager.addChatString("check3",chatId, userId);
        chatManager.addChatString("check4",userId, chatId);

        chatManager.addChatString("check5",chatId, chatId);
        chatManager.addChatString("check6",userId, userId);
        chatManager.addChatString("check7",userId, 3);
        chatManager.addChatString("check8",3, userId);*/
        String fullName = UserManager.getUserNameById(chatId);
        String type = UserManager.getTypeById(chatId);

        List<Chat> chatList = chatManager.getChatEntries(userId,chatId);
        model.addAttribute("chatStrings", chatList);
        model.addAttribute("subscriber", subscriberService.getUserById(userId));
        model.addAttribute("massageForm", new Chat(userId, chatId));
        model.addAttribute("users", usersList);
        model.addAttribute("type", "Chat with " + type + " (" + fullName + ")");

        // log and create the response json string
       // ChatAndVersion cav = new ChatAndVersion(chatEntries, chatManagerVersion);
       // logServerMessage("Server Chat version: " + chatManagerVersion + ", User '" + username + "' Chat version: " + chatVersion);
        //logServerMessage(jsonResponse);


        return "alertsPage";
    }

    @PostMapping(value = "/alert/userId={userId}&chat={chatId}", params="send")
    public String sendMassages(@PathVariable int userId,@PathVariable int chatId, Chat chat, Model model)
    {
        List<User> usersList = new ArrayList<>();
        usersList.addAll(UserManager.getUsersSet());
        User myuser = usersList.stream().filter(users -> users.getUserId() == userId).collect(Collectors.toList()).get(0);
        usersList.remove(myuser);
        chatManager.addChatString(chat.getContent(),userId, chat.getChatId());
        List<Chat> chatList = chatManager.getChatEntries(userId,chat.getChatId());
        String fullName = UserManager.getUserNameById(chatId);
        String type = UserManager.getTypeById(chatId);
        model.addAttribute("chatStrings", chatList);
        model.addAttribute("massageForm", new Chat(chat.getUserId(),chat.getChatId()));
        model.addAttribute("users", usersList);
        model.addAttribute("subscriber", subscriberService.getUserById(userId));
        model.addAttribute("type", "Chat with " + type + "(" + fullName + ")");



        return "alertsPage";
    }
}
