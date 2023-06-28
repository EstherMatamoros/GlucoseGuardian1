package it.unicas.products.action.glucose;

import com.opensymphony.xwork2.ActionSupport;
import it.unicas.products.dao.glucoseManagementDAO;
import it.unicas.products.pojo.Glucose;
import org.apache.struts2.ServletActionContext;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

public class glucoseManagementAction extends ActionSupport {
    private List<Glucose> glucoses;
    private Integer measurement;
    private Date createdDate;
    private Integer user_id;
    private Timestamp timestamp;
    private Integer id;

    public void initializeProducts() {
        System.out.println("****** Filter Data ******");
        System.out.println(measurement);
        System.out.println(createdDate);
        String createdDateStr = "";
        user_id = (Integer) ServletActionContext.getRequest().getSession().getAttribute("loggedInUserId"); // Assign the value to the class field

        if(createdDate != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
            createdDateStr = formatter.format(createdDate);
        }
        glucoses = glucoseManagementDAO.getAllGlucose(measurement, createdDateStr, user_id);
    }

    public String execute() {
        initializeProducts();
        return "success";
    }

    public List<Glucose> getGlucoses() {
        return glucoses;
    }

    public void setGlucoses(List<Glucose> glucoses) {
        this.glucoses = glucoses;
    }

    public Integer getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Integer measurement) {
        this.measurement = measurement;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
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

    @Override
    public String toString() {
        return "glucoseManagementAction{" +
                "glucoses=" + glucoses +
                ", measurement=" + measurement +
                ", createdDate=" + createdDate +
                ", user_id=" + user_id +
                ", timestamp=" + timestamp +
                ", id=" + id +
                '}';
    }
}