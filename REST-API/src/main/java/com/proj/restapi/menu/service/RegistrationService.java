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

        /*if (!isUserExistByEmail(info.getEmail()))
        {
            int userId = getAvalibleId();
            String sqlInsert = "insert into [User] values (?,?,?,?,?)";
            val = jdbcTemplate.update(sqlInsert, userId,info.getFirstname() , info.getLastname()
                    , info.getPhonenumber() , info.getEmail());
        }*/
        return val;
    }

    public boolean isUserExist(String email, String pass, String type){
        boolean res = true;
        try {
            int id = getUserIdByEmail(email);
            res = checkTypeByUserId (id, type);
            return getPasswordByUserId(id).equals(pass)&&res==true ? true : false;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public int getUserIdByEmail(String email){
        String sqlUser = "SELECT userId FROM [User] where email=?";
        Integer userId = jdbcTemplate.queryForObject(sqlUser,new Object[] { email }, Integer.class);
        return userId;
    }

    public boolean checkTypeByUserId(int userId, String type)
    {
        String sqlUser = "SELECT COUNT(*) FROM $tableName where userId=?";
        String query = sqlUser.replace("$tableName",type);

        int exist = jdbcTemplate.queryForObject(query,new Object[] { userId }, Integer.class);
        return exist==0? false:true;
    }

    public String getPasswordByUserId(int userId)
    {
        String sqlUser = "SELECT passwd FROM Auth where userId=?";
        String pass = jdbcTemplate.queryForObject(sqlUser,new Object[] { userId }, String.class);
        return pass;
    }

   private int getAvalibleId() {
       String sqlQuery = "SELECT TOP (1) [userId] FROM [MMC-Fitness].[dbo].[Auth] ORDER BY [userId] DESC";
       int id = jdbcTemplate.queryForObject(sqlQuery, Integer.class);
       id++;
       return id;
   }
}
