package it.unicas.products.action.exercise;

import com.opensymphony.xwork2.ActionSupport;
import it.unicas.products.dao.exerciseManagementDAO;
import it.unicas.products.pojo.ExerciseInfo;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import java.util.Map;

public class UpdateDataAction extends ActionSupport implements SessionAware {
    private SessionMap<String, Object> sessionMap;
    private Integer user_id;
    private Integer burned_calories;
    private Integer amount_time;
    private String date;
    private Integer exercise_id;
    private ExerciseInfo exerciseInfo;

    public String execute() {
        exerciseInfo = exerciseManagementDAO.getExerciseByID(exercise_id);
        sessionMap.put("exerciseInfoToUpdate", exerciseInfo);

        if (exerciseInfo != null) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
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

    public Integer getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(Integer exercise_id) {
        this.exercise_id = exercise_id;
    }

    public ExerciseInfo getExerciseInfo() {
        return exerciseInfo;
    }

    public void setExerciseInfo(ExerciseInfo exerciseInfo) {
        this.exerciseInfo = exerciseInfo;
    }

    @Override
    public String toString() {
        return "UpdateDataAction{" +
                "sessionMap=" + sessionMap +
                ", user_id=" + user_id +
                ", burned_calories=" + burned_calories +
                ", amount_time=" + amount_time +
                ", date='" + date + '\'' +
                ", exercise_id=" + exercise_id +
                ", exerciseInfo=" + exerciseInfo +
                '}';
    }
}