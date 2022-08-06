package general;

import java.util.Objects;

public class Meal {
    private int menuId;
    private int numOfMealInDay;
    private String mealInDay;
    private int calories;
    private String items;

    public Meal() {
    }

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
        mealInDay = mealInDay;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return menuId == meal.menuId && numOfMealInDay == meal.numOfMealInDay && calories == meal.calories && Objects.equals(mealInDay, meal.mealInDay) && Objects.equals(items, meal.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId, numOfMealInDay, mealInDay, calories, items);
    }
}
