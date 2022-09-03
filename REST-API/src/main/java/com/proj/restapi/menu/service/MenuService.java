package com.proj.restapi.menu.service;
import java.sql.Timestamp;
import java.util.List;

import general.Meal;
import general.Menu;
import general.SubscriberToMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class MenuService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Menu getMenuById(int userId) {
        //TODO - get menu from db - to open transaction
        String sqlSubToMenu = "SELECT * FROM [SubscriberToMenu] where userId=" + userId;
        SubscriberToMenu subscriberToMenu = jdbcTemplate.queryForObject(sqlSubToMenu, BeanPropertyRowMapper.newInstance(SubscriberToMenu.class));
        String sqlMenu = "SELECT * FROM [Menu] where menuId=" + subscriberToMenu.getMenuId();
        Menu menu =jdbcTemplate.queryForObject(sqlMenu, BeanPropertyRowMapper.newInstance(Menu.class));

        return menu;
    }

    public List<Meal> getMenuMealsById(int userId) {
        String sqlSubToMenu = "SELECT * FROM [SubscriberToMenu] where userId=" + userId;
        SubscriberToMenu subscriberToMenu = jdbcTemplate.queryForObject(sqlSubToMenu, BeanPropertyRowMapper.newInstance(SubscriberToMenu.class));
        String sqlMeals = "SELECT * FROM [Meal] where menuId=" + subscriberToMenu.getMenuId();
        List<Meal> meals =jdbcTemplate.query(sqlMeals, BeanPropertyRowMapper.newInstance(Meal.class));

        return meals;
    }

    List<Menu> getAllMenus() {
        return null;

    }
}
