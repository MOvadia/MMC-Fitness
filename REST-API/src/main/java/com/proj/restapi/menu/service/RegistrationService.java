package com.proj.restapi.menu.service;
import com.proj.restapi.auth.info.SubscriberInformation;
import general.Subscriber;
import general.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.sql.JDBCType.NULL;

@Service
public class RegistrationService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createUser(SubscriberInformation info){
        int val1 = 0, val2 = 0, val3 = 0;
        String sqlInsert;
        if (!isUserExistByEmail(info.getEmail()))
        {
            int userId = getAvalibleId();
            if(info.getType().equals("Subscriber")) {
                sqlInsert = "insert into $tableName values (?,?,?,?,?,?,?,?,?,?,?)";
                String query = sqlInsert.replace("$tableName", info.getType());
                val3 = jdbcTemplate.update(query, userId , info.getAge(), info.getHeight(),info.getWeight(),
                        info.getDietaryLimitationsString(),"none",info.getGender(),info.getWorkoutAmount(),
                        info.getTargetFatPercentage(),info.getTargetWeight(),info.getBmi());
                String sysEvent = "insert into $tableName values (?,?,?)";
                query = sysEvent.replace("$tableName", "SystemEvents");
                int val4 = jdbcTemplate.update(query, userId , info.getWeight(), 1);
            }
            else {
                sqlInsert = "insert into $tableName values (?,?)";
                String query = sqlInsert.replace("$tableName", info.getType());
                val3 = jdbcTemplate.update(query, userId, info.getSeniority());
            }

            sqlInsert = "insert into [User] values (?,?,?,?,?)";
            val1 = jdbcTemplate.update(sqlInsert, userId,info.getFirstname() , info.getLastname()
                    , info.getPhonenumber() , info.getEmail());

            sqlInsert = "insert into [Auth] values (?,?)";
            val2 = jdbcTemplate.update(sqlInsert, userId,info.getPsw());

        }
        return val1*val2*val3;
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

    public boolean isUserExistByEmail(String email){
        String sqlUser = "SELECT * FROM [User] where email=?";
        List<User> users = jdbcTemplate.query(sqlUser,new Object[] { email },
                BeanPropertyRowMapper.newInstance(User.class));
        return users.isEmpty()? false:true;
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

    public String getFirstNameByEmail(String email){
        String sqlFirstName = "SELECT firstName FROM [User] where email=?";
        String firstName = jdbcTemplate.queryForObject(sqlFirstName,new Object[] { email }, String.class);
        return firstName;
    }

    public String getLastNameByEmail(String email){
        String sqlLastName = "SELECT lastName FROM [User] where email=?";
        String lastName = jdbcTemplate.queryForObject(sqlLastName,new Object[] { email }, String.class);
        return lastName;
    }
}
