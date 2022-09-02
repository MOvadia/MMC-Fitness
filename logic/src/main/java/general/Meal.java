package general;

import java.util.Objects;

public class Meal {
    private int menuId;
    private int numOfMealInDay;
    private String mealInDay;
    private int calories;
    private String items;

    public Meal() {

    };

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getNumOfMealInDay() {
        return numOfMealInDay;
    }

    public void setNumOfMealInDay(int numOfMealInDay) {
        this.numOfMealInDay = numOfMealInDay;
    }

    public String getMealInDay() {
        return mealInDay;
    }

    public void setMealInDay(String mealInDay) {
        this.mealInDay = mealInDay;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }
}
