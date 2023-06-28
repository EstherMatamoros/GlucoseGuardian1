package it.unicas.products.action.diet;

import com.opensymphony.xwork2.ActionSupport;
import it.unicas.products.dao.dietManagementDAO;

public class DeleteAction extends ActionSupport {

    private Integer diet_id;

    public String execute() {
        String statusCode = "";

        int recordDeleted = dietManagementDAO.deleteDietInfo(diet_id);
        if (recordDeleted == 1) {
            statusCode = "success";
        } else {
            statusCode = "error";
        }
        return statusCode;
    }

    public Integer getDiet_id() {
        return diet_id;
    }

    public void setDiet_id(Integer diet_id) {
        this.diet_id = diet_id;
    }
}
