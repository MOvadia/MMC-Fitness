package com.proj.restapi.menu.service;
import general.Subscriber;
import general.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public int updateSubscriber(Subscriber user){
        String subscriber = "UPDATE [Subscriber] SET height=?, weight=?, workoutAmount=?,targetFatPercentage=?,targetWeight=? where userId=?";
        int ret1 = jdbcTemplate.update(subscriber, user.getHeight(), user.getWeight(), user.getWorkoutAmount(),
                user.getTargetFatPercentage(), user.getTargetWeight(), user.getUserId());
        String sql = "UPDATE [User] SET firstName=?, lastName=?, phoneNumber=? where email=?";
        int ret2 = jdbcTemplate.update(sql, user.getFirstName() , user.getLastName()
                , user.getPhoneNumber(),  user.getEmail());
        return ret1*ret2;
    }
}
