import java.sql.Timestamp;
import java.util.Objects;

public class Workout {
    private Integer workoutId;
    private String name;
    private Integer createdBy;
    private Timestamp timestamp;
    private String description;
    private enum focus{};
    private enum type{};
    private String link;
    private Float popularity;

    public Workout(Integer workoutId, String name, Integer createdBy, Timestamp timestamp, String description, String link, Float popularity) {
        this.workoutId = workoutId;
        this.name = name;
        this.createdBy = createdBy;
        this.timestamp = timestamp;
        this.description = description;
        this.link = link;
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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
        return workoutId.equals(workout.workoutId) && name.equals(workout.name) && createdBy.equals(workout.createdBy) && timestamp.equals(workout.timestamp) && description.equals(workout.description) && link.equals(workout.link) && popularity.equals(workout.popularity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workoutId, name, createdBy, timestamp, description, link, popularity);
    }
}
