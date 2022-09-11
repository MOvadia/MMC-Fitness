package com.proj.restapi.nutritionist.service;
import com.proj.restapi.actionresult.ActionResult;
import com.proj.restapi.auth.info.MenuInformation;
import com.proj.restapi.auth.info.WorkoutInformation;
import general.Menu;
import general.User;
import general.Nutritionist;
import general.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class NutritionistService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Integer userId;

    public Nutritionist getNutritionistId(int id){
        userId = id;
        String sqlUser = "SELECT * FROM [User] where userId=" + id;
        List<User> users = jdbcTemplate.query(sqlUser,
                BeanPropertyRowMapper.newInstance(User.class));
        String sqlNutritionist = "SELECT * FROM Nutritionist where userId=" + id;
        List<Nutritionist> n = jdbcTemplate.query(sqlNutritionist,
                BeanPropertyRowMapper.newInstance(Nutritionist.class));
        Nutritionist nutritionist = new Nutritionist(users.get(0), n.get(0));
        return nutritionist;
    }

    public void editMenu(Menu menu) {
//        userId = id;
//        String sql = "UPDATE meal SET menuId = " + mi.getMenuId() + " ,mealInDay = " + mi.getMealInDay() + ", calories = " + mi.;
//        List<User> users = jdbcTemplate.update(sqlUser,
//                BeanPropertyRowMapper.newInstance(User.class));
//        String sqlNutritionist = "SELECT * FROM Nutritionist where userId=" + id;
//        List<Nutritionist> n = jdbcTemplate.query(sqlNutritionist,
//                BeanPropertyRowMapper.newInstance(Nutritionist.class));
//        Nutritionist nutritionist = new Nutritionist(users.get(0), n.get(0));
//        return nutritionist;
//
//        UPDATE table_name
//        SET column1 = value1, column2 = value2, ...
//        WHERE condition;
//        addMenu(mi, 1);

    }

    public void addMenu(MenuInformation mi) {
        Integer menuId;
        String sqlAllMenus= "SELECT * FROM [Menu]";
        List<Menu> menus = jdbcTemplate.query(sqlAllMenus, BeanPropertyRowMapper.newInstance(Menu.class));
        Menu menu = menus.stream().max(Comparator.comparing(Menu::getMenuId))
                .orElseThrow(NoSuchElementException::new);
        menus = menus.stream().filter(m -> m.getName().equals(mi.getMenuName())).collect(Collectors.toList());
        if(menus.isEmpty()) {
            String sqlInsert = "insert into [Menu] values (?,?,?,?,?,?)";
            menuId = menu.getMenuId() + 1;
            jdbcTemplate.update(sqlInsert, menuId, mi.getMenuName(), userId, mi.getFatPercentage(), mi.getProtein(), mi.getType());
        } else {
            menuId = getMenuIdByName(mi.getMenuName());
        }
        addMenu(mi, menuId);

   }


    public void addMenu(MenuInformation mi, Integer menuId) {
        String sqlInsertBreakfast = "insert into [Meal] values (?,?,?)";
        jdbcTemplate.update(sqlInsertBreakfast, menuId, "Breakfast", mi.getBreakfast());
        String sqlInsertSnake1 = "insert into [Meal] values (?,?,?)";
        jdbcTemplate.update(sqlInsertSnake1, menuId, "Snake", mi.getSnake1());
        String sqlInsertLunch = "insert into [Meal] values (?,?,?)";
        jdbcTemplate.update(sqlInsertLunch, menuId, "Lunch", mi.getLunch());
        String sqlInsertSnake2 = "insert into [Meal] values (?,?,?)";
        jdbcTemplate.update(sqlInsertSnake2, menuId, "Snake", mi.getSnake2());
        String sqlInsertDinner = "insert into [Meal] values (?,?,?)";
        jdbcTemplate.update(sqlInsertDinner, menuId, "Dinner", mi.getDinner());
        String sqlInsertToSubscriberToMenu = "insert into [SubscriberToMenu] values (?,?)";
        jdbcTemplate.update(sqlInsertToSubscriberToMenu, getUserIdByEmail(mi.getAssignedUser()), menuId);
    }

    public int getUserIdByEmail(String email){
        String sqlUser = "SELECT userId FROM [User] where email=?";
        return userId = jdbcTemplate.queryForObject(sqlUser,new Object[] { email }, Integer.class);
    }

    public Integer getMenuIdByName(String menuName){
        String sql = "SELECT menuId FROM [Menu] where name = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] { menuName }, Integer.class);
    }


    public List<Menu> getAllMenus(){
        String sql = "SELECT * FROM [Menu]";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Menu.class));
    }

    public ActionResult<String> deleteMenu(Integer menuId){
        try {
            return ActionResult.successMessage("The menu deleted successfully");
        } catch (Exception e) {
            return ActionResult.failed("Failed to delete the menu");
        }
    }

    public Integer getUserId() {
        return userId;
    }
}
