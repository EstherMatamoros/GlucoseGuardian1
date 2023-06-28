package it.unicas.products.action.exercise;

import com.opensymphony.xwork2.ActionSupport;
import it.unicas.products.dao.exerciseManagementDAO;
import it.unicas.products.pojo.ExerciseInfo;
import org.apache.struts2.ServletActionContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class exerciseManagementAction extends ActionSupport {
    private List<ExerciseInfo> exerciseInfos;
    private Integer burned_calories;
    private Integer amount_time;
    private Date date;
    private Integer user_id;
    private  Integer exercise_id;

    public void initializeProducts() {
        System.out.println("****** Filter Data ******");
        System.out.println(burned_calories);
        System.out.println(amount_time);
        System.out.println(date);
        String createdDateStr = "";
        user_id = (Integer) ServletActionContext.getRequest().getSession().getAttribute("loggedInUserId"); // Assign the value to the class field

        if(date != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
            createdDateStr = formatter.format(date);
        }
        exerciseInfos = exerciseManagementDAO.getAllExercise(burned_calories, amount_time, createdDateStr, user_id);
    }

    public String execute() {
        initializeProducts();
        return "success";
    }

    public List<ExerciseInfo> getExerciseInfos() {
        return exerciseInfos;
    }

    public void setExerciseInfos(List<ExerciseInfo> exerciseInfos) {
        this.exerciseInfos = exerciseInfos;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(Integer exercise_id) {
        this.exercise_id = exercise_id;
    }

    @Override
    public String toString() {
        return "exerciseManagementAction{" +
                "exerciseInfos=" + exerciseInfos +
                ", burned_calories=" + burned_calories +
                ", amount_time=" + amount_time +
                ", date=" + date +
                ", user_id=" + user_id +
                ", exercise_id=" + exercise_id +
                '}';
    }
}
