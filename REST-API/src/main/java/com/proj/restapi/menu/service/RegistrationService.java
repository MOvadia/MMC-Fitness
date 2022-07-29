package com.proj.restapi.menu.service;
import com.proj.restapi.auth.info.SubscriberInformation;
import general.Subscriber;
import general.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createUser(SubscriberInformation info){
        int val = 0;
        String sqlUser = "SELECT * FROM [User] where email=?";
        List<User> users = jdbcTemplate.query(sqlUser,new Object[] { info.getEmail() },
                BeanPropertyRowMapper.newInstance(User.class));
        if (users.isEmpty())
        {
            int userId = getAvalibleId();
            String sqlInsert = "insert into [User] values (?,?,?,?,?)";
            val = jdbcTemplate.update(sqlInsert, userId,info.getFirstname() , info.getLastname()
                    , info.getPhonenumber() , info.getEmail());
        }
        return val;
    }

   private int getAvalibleId() {
       String sqlQuery = "SELECT TOP (1) [userId] FROM [MMC-Fitness].[dbo].[Auth] ORDER BY [userId] DESC";
       int id = jdbcTemplate.queryForObject(sqlQuery, Integer.class);
       id++;
       return id;
   }
}
