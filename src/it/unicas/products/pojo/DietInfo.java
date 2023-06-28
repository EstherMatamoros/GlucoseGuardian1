package it.unicas.products.pojo;

import java.sql.Time;
import java.util.Calendar;

public class DietInfo {
    private Integer user_id;
    private String meal;
    private Integer carbs;
    private String datetime;
    private Integer diet_id;

    public DietInfo(String meal, Integer carbs, String datetime) {
        this.meal = meal;
        this.carbs = carbs;
        this.datetime = datetime;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public Integer getCarbs() {
        return carbs;
    }

    public void setCarbs(Integer carbs) {
        this.carbs = carbs;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Integer getDiet_id() {
        return diet_id;
    }

    public void setDiet_id(Integer diet_id) {
        this.diet_id = diet_id;
    }

    @Override
    public String toString() {
        return "DietInfo{" +
                "user_id=" + user_id +
                ", meal='" + meal + '\'' +
                ", carbs=" + carbs +
                ", datetime='" + datetime + '\'' +
                ", diet_id=" + diet_id +
                '}';
    }
}
