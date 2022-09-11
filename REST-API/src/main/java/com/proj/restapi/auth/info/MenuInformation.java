package com.proj.restapi.auth.info;

public class MenuInformation {

    private String menuName;
    private Float fatPercentage;
    private String type;
    private Integer calories;
    private Integer protein;
    private String assignedUser;
    private String mealInDay;
    private String breakfast;
    private String snake1;
    private String lunch;
    private String snake2;
    private String dinner;

    public MenuInformation(String menuName, Float fatPercentage, String type, Integer calories, Integer protein, String assignedUser, String mealInDay, String breakfast, String snake1, String lunch, String snake2, String dinner) {
        this.menuName = menuName;
        this.fatPercentage = fatPercentage;
        this.type = type;
        this.calories = calories;
        this.protein = protein;
        this.assignedUser = assignedUser;
        this.mealInDay = mealInDay;
        this.breakfast = breakfast;
        this.snake1 = snake1;
        this.lunch = lunch;
        this.snake2 = snake2;
        this.dinner = dinner;
    }

    public String getMealInDay() {
        return mealInDay;
    }

    public void setMealInDay(String mealInDay) {
        this.mealInDay = mealInDay;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getSnake1() {
        return snake1;
    }

    public void setSnake1(String snake1) {
        this.snake1 = snake1;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getSnake2() {
        return snake2;
    }

    public void setSnake2(String snake2) {
        this.snake2 = snake2;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public Float getFatPercentage() {
        return fatPercentage;
    }

    public void setFatPercentage(Float fatPercentage) {
        this.fatPercentage = fatPercentage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getProtein() {
        return protein;
    }

    public void setProtein(Integer protein) {
        this.protein = protein;
    }


    public MenuInformation() {
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(String assignedUser) {
        this.assignedUser = assignedUser;
    }
}