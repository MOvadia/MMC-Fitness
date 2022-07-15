package com.proj.restapi.menu.controller;

import com.proj.restapi.menu.service.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("menu")
public class MenuController {
    private MenuService menuService;


    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Object> addMenu(@RequestParam String id) {
        return null;
        //return new ResponseEntity<>(menuService.getMenuById(id), HttpStatus.OK);
    }
}
