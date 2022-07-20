package com.proj.restapi.menu.service;
import java.awt.*;
import java.sql.Timestamp;
import java.util.List;
import general.Menu;

public class MenuService {

    public static Menu getMenuById(int id) {
        //TODO - get menu from db - to open transaction
        Menu menu = new Menu(1, "menu without Carbohydrates", "may ovadia", new Timestamp(System.currentTimeMillis()), "description",
                50f, 20f , 1250, 400);
        return menu;
    }

    List<Menu> getAllMenus() {
        return null;

    }
}
