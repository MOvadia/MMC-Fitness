package com.proj.restapi.auth.info;

public class MenuInformation {

    private String menuName;
    private Float fatPercentage;
    private String type;
    private Integer calories;
    private Integer protein;
    private String assignedUser;
    private String mealInDay;
    private String item;

    public MenuInformation(String menuName, Float fatPercentage, String type, Integer calories, Integer protein, String assignedUser, String mealInDay, String item) {
        this.menuName = menuName;
        this.fatPercentage = fatPercentage;
        this.type = type;
        this.calories = calories;
        this.protein = protein;
        this.assignedUser = assignedUser;
        this.mealInDay = mealInDay;
        this.item = item;
    }

    public String getMealInDay() {
        return mealInDay;
    }

    public void setMealInDay(String mealInDay) {
        this.mealInDay = mealInDay;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
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