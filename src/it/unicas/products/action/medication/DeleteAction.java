package it.unicas.products.action.medication;

import com.opensymphony.xwork2.ActionSupport;
import it.unicas.products.dao.glucoseManagementDAO;
import it.unicas.products.dao.medicationManagementDAO;

import java.sql.Timestamp;

public class DeleteAction extends ActionSupport {

    private Integer id;

    public String execute() {
        String statusCode = "";

        int recordDeleted = medicationManagementDAO.deleteMedicationInfo(id);
        if (recordDeleted == 1) {
            statusCode = "success";
        } else {
            statusCode = "error";
        }
        return statusCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DeleteAction{" +
                "id=" + id +
                '}';
    }
}
