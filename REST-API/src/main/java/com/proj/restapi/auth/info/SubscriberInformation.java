package com.proj.restapi.auth.info;

import java.util.List;
import java.util.Objects;

public class SubscriberInformation {

    private String firstname;
    private String lastname;
    private String phonenumber;
    private String email;
    private String psw;
    private String type;

    private Integer age;
    private Float height;
    private Float weight;
    private String gender;
    private Integer workoutAmount;
    private Float targetFatPercentage;
    private Float targetWeight;
    private float bmi;


    private List<String> dietaryLimitations;

    private int seniority;

    public SubscriberInformation() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPsw() {
        return psw;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getWorkoutAmount() {
        return workoutAmount;
    }

    public void setWorkoutAmount(Integer workoutAmount) {
        this.workoutAmount = workoutAmount;
    }

    public Float getTargetFatPercentage() {
        return targetFatPercentage;
    }

    public void setTargetFatPercentage(Float targetFatPercentage) {
        this.targetFatPercentage = targetFatPercentage;
    }

    public Float getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(Float targetWeight) {
        this.targetWeight = targetWeight;
    }

    public String getDietaryLimitationsString() {
        String lines="";
        for (String line:dietaryLimitations){
             lines+= line +"," ;
        }
        return lines;
    }

    public List<String> getDietaryLimitations() {
        return dietaryLimitations;
    }

    public void setDietaryLimitations(List<String> dietaryLimitations) {
        this.dietaryLimitations = dietaryLimitations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubscriberInformation)) return false;
        SubscriberInformation that = (SubscriberInformation) o;
        return seniority == that.seniority && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(phonenumber, that.phonenumber) && Objects.equals(email, that.email) && Objects.equals(psw, that.psw) && Objects.equals(type, that.type) && Objects.equals(age, that.age) && Objects.equals(height, that.height) && Objects.equals(weight, that.weight) && Objects.equals(workoutAmount, that.workoutAmount) && Objects.equals(targetFatPercentage, that.targetFatPercentage) && Objects.equals(targetWeight, that.targetWeight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, phonenumber, email, psw, type, age, height, weight, workoutAmount, targetFatPercentage, targetWeight, seniority);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public float getBmi() {
        float bmi = weight / (height*height);
        return bmi;
    }

    public void setBmi(float bmi) {
        this.bmi = bmi;
    }
}
