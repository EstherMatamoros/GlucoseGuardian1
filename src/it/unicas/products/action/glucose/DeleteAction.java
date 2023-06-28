package it.unicas.products.action.glucose;

import com.opensymphony.xwork2.ActionSupport;
import it.unicas.products.dao.glucoseManagementDAO;


import java.sql.Timestamp;

public class DeleteAction extends ActionSupport {

    private Timestamp timestamp;
    private Integer id;

    public String execute() {
        String statusCode = "";

        int recordDeleted = glucoseManagementDAO.deleteGlucose(timestamp);
        if (recordDeleted == 1) {
            statusCode = "success";
        } else {
            statusCode = "error";
        }
        return statusCode;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

}
