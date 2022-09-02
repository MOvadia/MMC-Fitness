package com.proj.restapi.menu.service;

import general.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Meal> getMealsByMenuId(int menuId) {
        String sql = "SELECT * FROM [Meal] where menuId=" + menuId;
        List<Meal> meals = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Meal.class));

        return meals;
    }

}
