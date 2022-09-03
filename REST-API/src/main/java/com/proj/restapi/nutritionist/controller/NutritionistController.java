package com.proj.restapi.nutritionist.controller;

import com.proj.restapi.auth.info.LoginInformation;
import com.proj.restapi.auth.info.MenuInformation;
import com.proj.restapi.nutritionist.service.NutritionistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NutritionistController {
    @Autowired
    private NutritionistService nutritionistService = new NutritionistService();

    @PostMapping(value = "/menu/add")
    public String addmenu(Model model, MenuInformation menuInfo) {
        int id = nutritionistService.getUserId();
        nutritionistService.addMenu(menuInfo);

        model.addAttribute("menuForm", menuInfo);
        model.addAttribute("userForm", new LoginInformation());
        model.addAttribute("nutritionist", nutritionistService.getNutritionistId(id));
        model.addAttribute("menu", nutritionistService.getAllMenus());
        model.addAttribute("gender", "Male"); //TODO ???
        //   model.addAttribute("menu", menuService.getmenuPerUserId(1));
        return "mainPageNutritionist";
    }

    @DeleteMapping(value = "/{menuId}")
    public ResponseEntity<Object> deletemenu(@PathVariable int menuId) {
        return new ResponseEntity<>(nutritionistService.deleteMenu(menuId), HttpStatus.OK);
    }

    @GetMapping("/nutritionist/login/userId={userId}")
    public String registerUser(@PathVariable int userId, Model model)
    {
        model.addAttribute("userForm", new LoginInformation());
        //TODO - need to get user data from DB
        //TODO - get from DB the userID - than get the nutritionist by UserId
        int id = userId;
        model.addAttribute("nutritionist", nutritionistService.getNutritionistId(id));
        model.addAttribute("menu", nutritionistService.getAllMenus());
        model.addAttribute("gender", "Male");
     //   model.addAttribute("menu", menuService.getmenuPerUserId(1));
        return "mainPageNutritionist";
    }
}
