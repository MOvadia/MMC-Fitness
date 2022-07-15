import java.sql.Timestamp;
import java.util.Objects;

public class SystemEvents {
    private Integer userId;
    private Float currentWeight;
    private Float currentFatPercentage;
    private Timestamp timestamp;

    public SystemEvents(Integer userId, Float currentWeight, Float currentFatPercentage, Timestamp timestamp) {
        this.userId = userId;
        this.currentWeight = currentWeight;
        this.currentFatPercentage = currentFatPercentage;
        this.timestamp = timestamp;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Float getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(Float currentWeight) {
        this.currentWeight = currentWeight;
    }

    public Float getCurrentFatPercentage() {
        return currentFatPercentage;
    }

    public void setCurrentFatPercentage(Float currentFatPercentage) {
        this.currentFatPercentage = currentFatPercentage;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SystemEvents that = (SystemEvents) o;
        return userId.equals(that.userId) && currentWeight.equals(that.currentWeight) && currentFatPercentage.equals(that.currentFatPercentage) && timestamp.equals(that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, currentWeight, currentFatPercentage, timestamp);
    }
}
