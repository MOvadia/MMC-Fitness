package com.proj.restapi.trainer.service;
import com.proj.restapi.actionresult.ActionResult;
import com.proj.restapi.auth.info.WorkoutInformation;
import general.SubscriberToMenu;
import general.Trainer;
import general.User;
import general.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

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
        Integer workoutId;
        String sqlAllWorkout = "SELECT * FROM [Workout]";
        List<Workout> workouts = jdbcTemplate.query(sqlAllWorkout, BeanPropertyRowMapper.newInstance(Workout.class));
        Integer workoutsCount = workouts.size();
        workouts = workouts.stream().filter(w -> w.getName().equals(wi.getWorkoutName())).collect(Collectors.toList());
        if(workouts.isEmpty()) {
            String sqlInsert = "insert into [Workout] values (?,?,?,?,?,?)";
            workoutId = ++workoutsCount;
            jdbcTemplate.update(sqlInsert, workoutId, wi.getWorkoutName(), userId, "power......", "power", 90);
        } else {
            workoutId = getWorkoutIdByName(wi.getWorkoutName());
        }
        addExercise(wi, workoutId);
    }

    public void addExercise(WorkoutInformation wi, Integer workoutId) {
        String sqlInsert = "insert into [Exercise] values (?,?,?,?,?,?)";
        jdbcTemplate.update(sqlInsert, workoutId, wi.getExerciseName(), wi.getSetNum(), wi.getRepNum(), wi.getDescription(), wi.getLink());
    }

    public List<Workout> getAllWorkouts(){
        String sqlAllWorkout = "SELECT * FROM [Workout]";
        return jdbcTemplate.query(sqlAllWorkout, BeanPropertyRowMapper.newInstance(Workout.class));
    }

    public Integer getWorkoutIdByName(String workoutName){
        String sql = "SELECT workoutId FROM [Workout] where name = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] { workoutName }, Integer.class);
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
