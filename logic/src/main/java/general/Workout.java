package general;

import java.sql.Timestamp;
import java.util.Objects;

public class Workout {
    private Integer workoutId;
    private String name;
    private Integer createdBy;
    private String description;
    private enum focus{};
    private enum type{};
    private Float popularity;

    public Workout() {

    }

    public Workout(Integer workoutId, String name, Integer createdBy, String description, Float popularity) {
        this.workoutId = workoutId;
        this.name = name;
        this.createdBy = createdBy;
        this.description = description;
        this.popularity = popularity;
    }

    public Integer getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Integer workoutId) {
        this.workoutId = workoutId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPopularity() {
        return popularity;
    }

    public void setPopularity(Float popularity) {
        this.popularity = popularity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workout workout = (Workout) o;
        return workoutId.equals(workout.workoutId) && name.equals(workout.name) && createdBy.equals(workout.createdBy) && description.equals(workout.description) && popularity.equals(workout.popularity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workoutId, name, createdBy, description, popularity);
    }
}
