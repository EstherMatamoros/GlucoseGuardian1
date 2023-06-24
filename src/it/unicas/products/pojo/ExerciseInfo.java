package it.unicas.products.pojo;

public class ExerciseInfo {

    private Integer user_id;
    private Integer burned_calories;
    private Integer amount_time;
    private String date;

    public ExerciseInfo(Integer burned_calories, Integer amount_time, String date) {
        this.burned_calories = burned_calories;
        this.amount_time = amount_time;
        this.date = date;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getBurned_calories() {
        return burned_calories;
    }

    public void setBurned_calories(Integer burned_calories) {
        this.burned_calories = burned_calories;
    }

    public Integer getAmount_time() {
        return amount_time;
    }

    public void setAmount_time(Integer amount_time) {
        this.amount_time = amount_time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ExerciseInfo{" +
                "user_id=" + user_id +
                ", burned_calories=" + burned_calories +
                ", amount_time=" + amount_time +
                ", date='" + date + '\'' +
                '}';
    }
}
