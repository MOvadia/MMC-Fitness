package general;

import java.util.Objects;

public class Exercise {
    private int workoutId;
    private String exercise;
    private int repetNum;
    private String description;

    public Exercise() {
    }

    public int getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(int workoutId) {
        this.workoutId = workoutId;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public int getRepetNum() {
        return repetNum;
    }

    public void setRepetNum(int repetNum) {
        this.repetNum = repetNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercise exercise1 = (Exercise) o;
        return workoutId == exercise1.workoutId && repetNum == exercise1.repetNum && exercise.equals(exercise1.exercise) && Objects.equals(description, exercise1.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workoutId, exercise, repetNum, description);
    }
}
