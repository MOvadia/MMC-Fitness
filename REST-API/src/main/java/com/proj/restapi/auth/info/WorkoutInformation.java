package com.proj.restapi.auth.info;

public class WorkoutInformation {

    private String workoutName;
    private String link;
    private Integer setNum;
    private Integer repNum;
    private String exerciseName;
    private String focus;
    private String description;

    private String assignedUser;

    public WorkoutInformation() {
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getRepNum() {
        return repNum;
    }

    public void setRepNum(Integer repNum) {
        this.repNum = repNum;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public void setSetNum(Integer setNum) {
        this.setNum = setNum;
    }

    public Integer getSetNum() {
        return setNum;
    }

    public String getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(String assignedUser) {
        this.assignedUser = assignedUser;
    }

    public String getFocus() {
        return focus;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}