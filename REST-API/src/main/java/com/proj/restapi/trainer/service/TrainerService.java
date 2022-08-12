package com.proj.restapi.trainer.service;
import com.proj.restapi.actionresult.ActionResult;
import general.Trainer;
import general.User;
import general.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

@Service
public class TrainerService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Trainer getTrainerId(int id){
        String sqlUser = "SELECT * FROM [User] where userId=" + id;
        List<User> users = jdbcTemplate.query(sqlUser,
                BeanPropertyRowMapper.newInstance(User.class));
        String sqlTrainer = "SELECT * FROM Trainer where userId=" + id;
        List<Trainer> t = jdbcTemplate.query(sqlTrainer,
                BeanPropertyRowMapper.newInstance(Trainer.class));
        Trainer trainer = new Trainer(users.get(0), t.get(0));
        //customers.forEach(System.out :: println);
        return trainer;
    }

    public static List<Workout> getAllWorkouts(){
        //TODO - get workout for the relevant user
        return Arrays.asList(
                new Workout(1, "Power Hands", 1,
                        new Timestamp(System.currentTimeMillis()), "This ...", "URL...", 40f ),
                new Workout(2, "Power legs", 2,
                        new Timestamp(System.currentTimeMillis()), "This ...", "URL...", 20f ),
                new Workout(3, "Pilatis", 3,
                        new Timestamp(System.currentTimeMillis()), "This ...", "URL...", 60f ),
                new Workout(4, "Yoga", 3,
                        new Timestamp(System.currentTimeMillis()), "This ...", "URL...", 60f )
        );
    }

    public static Workout getWorkoutForUserByWorkoutId(int userId, int workoutId){
        return new Workout(1, "Power Hands", 1,
                new Timestamp(System.currentTimeMillis()), "This ...", "URL...", 40f );
    }

    public ActionResult<String> addWorkout(Workout workout){
        try {
            //Connect to DB and update workouts table with the new workout
            return ActionResult.successMessage("The workout updated successfully");
        } catch (Exception e) {
            return ActionResult.failed("Failed to update the workout");
        }
    }

    public ActionResult<String> deleteWorkout(Integer workoutId){
        try {
            //Connect to DB and delete the specific workout from workouts table
            return ActionResult.successMessage("The workout deleted successfully");
        } catch (Exception e) {
            return ActionResult.failed("Failed to delete the workout");
        }
    }
}
