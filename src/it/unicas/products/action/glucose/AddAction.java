package it.unicas.products.action.glucose;

import com.opensymphony.xwork2.ActionSupport;
import it.unicas.products.dao.glucoseManagementDAO;
import it.unicas.products.pojo.Glucose;
import org.apache.struts2.ServletActionContext;

import java.sql.Timestamp;


public class AddAction extends ActionSupport {
    private Integer measurement;
    private String createdDate;

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

    public String execute() {
        String statusCode = "";
        Integer userId = (Integer) ServletActionContext.getRequest().getSession().getAttribute("loggedInUserId");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        if (userId != null) {
            Glucose glucose = new Glucose(measurement, createdDate);
            glucose.setUser_id(userId);
            glucose.setTimestamp(timestamp);

            int recordAdded = glucoseManagementDAO.addGlucose(glucose);

            if (glucose.getId() > 0) {
                statusCode = SUCCESS;
            } else {
                statusCode = ERROR;
            }
        }

        return statusCode;
    }

    @Override
    public String toString() {
        return "AddAction{" +
                "measurement=" + measurement +
                ", createdDate='" + createdDate + '\'' +
                '}';
    }
}