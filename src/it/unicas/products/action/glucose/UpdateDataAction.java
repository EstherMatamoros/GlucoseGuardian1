package it.unicas.products.action.glucose;

import com.opensymphony.xwork2.ActionSupport;
import it.unicas.products.dao.glucoseManagementDAO;
import it.unicas.products.pojo.Glucose;
import java.sql.Timestamp;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class UpdateDataAction extends ActionSupport implements SessionAware {
    private SessionMap<String, Object> sessionMap;

    private Integer measurement;
    private String createdDate;
    private Integer user_id;
    private Timestamp timestamp;
    private Integer id;
    private Glucose glucose; // Add this property to hold the fetched glucose record


    public String execute() {
        System.out.println("execute() in updateDataAction method called");

        // Fetch the glucose record based on id and timestamp
        glucose = glucoseManagementDAO.getGlucoseByIDAndTimestamp(id, timestamp);
        System.out.print("updateDataAction glucoseManagementDAO.getGlucoseByIDAndTimestamp(id, timestamp)");
        System.out.println(glucose);
        sessionMap.put("glucoseToUpdate", glucose);



        if (glucose != null) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
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

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Glucose getGlucose() {
        return glucose;
    }

    public void setGlucose(Glucose glucose) {
        this.glucose = glucose;
    }

    @Override
    public String toString() {
        return "UpdateDataAction{" +
                "measurement=" + measurement +
                ", createdDate='" + createdDate + '\'' +
                ", user_id=" + user_id +
                ", timestamp=" + timestamp +
                ", id=" + id +
                ", glucose=" + glucose +
                '}';
    }
}