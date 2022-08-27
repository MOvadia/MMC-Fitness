package com.proj.restapi.menu.service;
import general.Subscriber;
import general.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.sql.JDBCType.NULL;

@Service
public class SubscriberService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Subscriber getSubscriberById(int id){
        String sqlUser = "SELECT * FROM [User] where userId=" + id;
        List<User> users = jdbcTemplate.query(sqlUser,
                BeanPropertyRowMapper.newInstance(User.class));
        String sqlSubscriber = "SELECT * FROM Subscriber where userId=" + id;
        List<Subscriber> s = jdbcTemplate.query(sqlSubscriber,
                BeanPropertyRowMapper.newInstance(Subscriber.class));
        Subscriber subscriber = new Subscriber(users.get(0), s.get(0));
        //customers.forEach(System.out :: println);
        return subscriber;
    }

    public User getUserById(int id){
        String sqlUser = "SELECT * FROM [User] where userId=" + id;
        List<User> users = jdbcTemplate.query(sqlUser,
                BeanPropertyRowMapper.newInstance(User.class));

        return users.get(0);
    }

    public int getUserIdByEmail(String email){
        String sqlUser = "SELECT userId FROM [User] where email=?";
        Integer userId = jdbcTemplate.queryForObject(sqlUser,new Object[] { email }, Integer.class);
        return userId;
    }

    private int getNewWeek(int userId) {
        Object[] params = new Object[]  {userId};
        String sqlQuery = "SELECT TOP (1) [week] FROM [MMC-Fitness].[dbo].[SystemEvents] WHERE userId=? ORDER BY [week] DESC";
        int id = jdbcTemplate.queryForObject(sqlQuery,params, Integer.class);
        id++;
        return id;
    }

    public int updateSubscriber(Subscriber user){
        int id = getUserIdByEmail(user.getEmail());
        String subscriber = "UPDATE [Subscriber] SET height=?,age=?, weight=?, workoutAmount=?,targetFatPercentage=?,targetWeight=? where userId=?";
        int ret1 = jdbcTemplate.update(subscriber, user.getHeight(),user.getAge(), user.getWeight(), user.getWorkoutAmount(),
                user.getTargetFatPercentage(), user.getTargetWeight(), id);
        String sql = "UPDATE [User] SET firstName=?, lastName=?, phoneNumber=? where email=?";
        int ret2 = jdbcTemplate.update(sql, user.getFirstName() , user.getLastName()
                , user.getPhoneNumber(),  user.getEmail());

        int week = getNewWeek(id);
        String sysEvent = "insert into $tableName values (?,?,?)";
        String query = sysEvent.replace("$tableName", "SystemEvents");
        int ret3 = jdbcTemplate.update(query, id , user.getWeight(), week);
        return ret1+ret2+ret3;
    }
}

