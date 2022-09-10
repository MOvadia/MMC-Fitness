package general;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.Objects;

public class SystemEvents implements Comparator<SystemEvents> {
    private Integer userId;
    private double currentWeight;
    private int week;

    public SystemEvents(){}
    public SystemEvents(Integer userId, double currentWeight, int week) {
        this.userId = userId;
        this.currentWeight = currentWeight;
        this.week = week;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SystemEvents)) return false;
        SystemEvents that = (SystemEvents) o;
        return Double.compare(that.currentWeight, currentWeight) == 0 && week == that.week && userId.equals(that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, currentWeight, week);
    }

    public int compare(SystemEvents a, SystemEvents b)
    {
        return a.week - b.week;
    }
}
