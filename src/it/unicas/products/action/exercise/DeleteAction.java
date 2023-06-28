package it.unicas.products.action.exercise;

import com.opensymphony.xwork2.ActionSupport;
import it.unicas.products.dao.exerciseManagementDAO;

public class DeleteAction extends ActionSupport {

    private Integer exercise_id;

    public String execute() {
        String statusCode = "";

        int recordDeleted = exerciseManagementDAO.deleteExerciseInfo(exercise_id);
        if (recordDeleted == 1) {
            statusCode = "success";
        } else {
            statusCode = "error";
        }
        return statusCode;
    }

    public Integer getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(Integer exercise_id) {
        this.exercise_id = exercise_id;
    }
}
