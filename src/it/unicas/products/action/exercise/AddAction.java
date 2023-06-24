package it.unicas.products.action.exercise;

import com.opensymphony.xwork2.ActionSupport;
import it.unicas.products.dao.exerciseManagementDAO;
import it.unicas.products.pojo.ExerciseInfo;
import org.apache.struts2.ServletActionContext;


import java.text.SimpleDateFormat;
import java.util.Date;

public class AddAction extends ActionSupport {

    private Integer burned_calories;
    private Integer amount_time;
    private String date;


    public String execute() {
        String statusCode = "";
        Integer userId = (Integer) ServletActionContext.getRequest().getSession().getAttribute("loggedInUserId");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String createdDateStr = formatter.format(new Date());

        if (userId != null){
            ExerciseInfo exerciseInfo = new ExerciseInfo(burned_calories, amount_time, createdDateStr);
            exerciseInfo.setBurned_calories(burned_calories);
            exerciseInfo.setAmount_time(amount_time);
            exerciseInfo.setUser_id(userId);
            int recordAdded = exerciseManagementDAO.addExercise(exerciseInfo);
            if (recordAdded == 1) {
                statusCode = SUCCESS;
            }
            else {
            statusCode = ERROR;
            }
        }
        return statusCode;
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
        return "AddAction{" +
                "burned_calories=" + burned_calories +
                ", amount_time=" + amount_time +
                ", date='" + date + '\'' +
                '}';
    }
}
