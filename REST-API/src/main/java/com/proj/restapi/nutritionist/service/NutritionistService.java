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
import java.util.List;
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


    public void addMenu(MenuInformation mi) {
        Integer menuId;
        String sqlAllMenus= "SELECT * FROM [Menu]";
        List<Menu> menus = jdbcTemplate.query(sqlAllMenus, BeanPropertyRowMapper.newInstance(Menu.class));
        Integer menuCount = menus.size();
        menus = menus.stream().filter(m -> m.getName().equals(mi.getMenuName())).collect(Collectors.toList());
        if(menus.isEmpty()) {
            String sqlInsert = "insert into [Menu] values (?,?,?,?,?,?)";
            menuId = ++menuCount;
            jdbcTemplate.update(sqlInsert, menuId, mi.getMenuName(), userId, mi.getType(), mi.getFatPercentage(), mi.getProtein());
        } else {
            menuId = getMenuIdByName(mi.getMenuName());
        }
        addMenu(mi, menuId);

   }

    public void addMenu(MenuInformation mi, Integer menuId) {
        String sqlInsert = "insert into [Meal] values (?,?,?,?)";
        jdbcTemplate.update(sqlInsert, menuId, mi.getMealInDay(), mi.getCalories(), mi.getItem());
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
}
