package it.unicas.products.action.glucose;

import com.opensymphony.xwork2.ActionSupport;
import it.unicas.products.dao.glucoseManagementDAO;
import it.unicas.products.pojo.Glucose;
import org.apache.struts2.ServletActionContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddAction extends ActionSupport {
    private Integer measurement;
    private String createdDate;

    public String execute() {
        String statusCode = "";
        Integer userId = (Integer) ServletActionContext.getRequest().getSession().getAttribute("loggedInUserId");

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String createdDateStr = formatter.format(new Date());
        if (userId != null) {
            Glucose glucose = new Glucose(measurement, createdDate);
            glucose.setMeasurement(measurement);
            glucose.setCreatedDate(createdDate);
            glucose.setUser_id(userId);

            int recordAdded = glucoseManagementDAO.addGlucose(glucose);
            if (recordAdded == 1) {
                statusCode = SUCCESS;
            } else {
                // User ID not found in the session
                statusCode = ERROR;
            }
        }

        return statusCode;
    }

    public Integer getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Integer measurement) {
        this.measurement = measurement;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "AddAction{" +
                "measurement=" + measurement +
                ", createdDate='" + createdDate + '\'' +
                '}';
    }
}
