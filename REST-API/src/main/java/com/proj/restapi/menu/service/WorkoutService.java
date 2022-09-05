package com.proj.restapi.menu.service;

import com.proj.restapi.actionresult.ActionResult;
import general.SubscriberToMenu;
import general.SubscriberToWorkout;
import general.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class WorkoutService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Workout> getWorkoutPerUserId(int userId){
        String sqlWorkoutsIds = "SELECT * FROM [SubscriberToWorkout] where userId = " + userId;
        List<SubscriberToWorkout> workoutsId = jdbcTemplate.query(sqlWorkoutsIds, BeanPropertyRowMapper.newInstance(SubscriberToWorkout.class));
        List<Workout> workouts = new ArrayList<>();
        for (SubscriberToWorkout stoW: workoutsId) {
            String sqlWorkouts = "SELECT * FROM [Workout] where workoutId = " + stoW.getWorkoutId();
            Workout workout = jdbcTemplate.queryForObject(sqlWorkouts, BeanPropertyRowMapper.newInstance(Workout.class));
            workouts.add(workout);
        }
        return workouts;
    }

    public static Workout getWorkoutForUserByWorkoutId(int userId, int workoutId){
        return new Workout(1, "Power Hands", 1,"This ...", 40f );
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
