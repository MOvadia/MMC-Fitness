package com.proj.restapi.trainer.service;
import com.proj.restapi.actionresult.ActionResult;
import com.proj.restapi.auth.info.WorkoutInformation;
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
import java.util.stream.Collectors;

@Service
public class TrainerService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Integer userId;

    public Trainer getTrainerId(int id){
        userId = id;
        String sqlUser = "SELECT * FROM [User] where userId=" + id;
        List<User> users = jdbcTemplate.query(sqlUser,
                BeanPropertyRowMapper.newInstance(User.class));
        String sqlTrainer = "SELECT * FROM Trainer where userId=" + id;
        List<Trainer> t = jdbcTemplate.query(sqlTrainer,
                BeanPropertyRowMapper.newInstance(Trainer.class));
        Trainer trainer = new Trainer(users.get(0), t.get(0));
        return trainer;
    }


    public void addWorkout(WorkoutInformation wi) {
        String sqlAllWorkout = "SELECT * FROM [Workout]";
        List<Workout> workouts = jdbcTemplate.query(sqlAllWorkout, BeanPropertyRowMapper.newInstance(Workout.class));
        Integer workoutId = workouts.size() + 1;
        workouts = workouts.stream().filter(w -> w.getName().equals(wi.getWorkoutName())).collect(Collectors.toList());
        if(workouts.isEmpty()) {
            String sqlInsert = "insert into [Workout] values (?,?,?,?,?,?,?)";
            jdbcTemplate.update(sqlInsert, workoutId, wi, wi.getWorkoutName(), userId, null, null, null, 0);

       }
    }

    public static List<Workout> getAllWorkouts(){
        //TODO - get workout for the relevant user
        return Arrays.asList(
                new Workout(1, "Power Hands", 1, "This ...", 40f ),
                new Workout(2, "Power legs", 2, "This ...", 20f ),
                new Workout(3, "Pilatis", 3, "This ...", 60f ),
                new Workout(4, "Yoga", 3, "This ...", 60f )
        );
    }

    public static Workout getWorkoutForUserByWorkoutId(int userId, int workoutId){
        return new Workout(1, "Power Hands", 1, "This ...", 40f );
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
