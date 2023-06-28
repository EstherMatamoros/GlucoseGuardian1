package it.unicas.products.action.appointments;

import com.opensymphony.xwork2.ActionSupport;
import it.unicas.products.dao.appointmentManagementDAO;
import it.unicas.products.pojo.AppointmentsInfo;
import org.apache.struts2.ServletActionContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddAction extends ActionSupport {

    private Integer appointments_id;
    private String area;
    private String date;
    private String doctor_name;
    private Integer user_id;


    public String execute() {
        String statusCode = "";
        Integer userId = (Integer) ServletActionContext.getRequest().getSession().getAttribute("loggedInUserId");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String createdDateStr = formatter.format(new Date());

        if (userId != null){
            AppointmentsInfo appointmentsInfo = new AppointmentsInfo(area,createdDateStr,doctor_name);
            appointmentsInfo.setArea(area);
            appointmentsInfo.setDoctor_name(doctor_name);
            appointmentsInfo.setUser_id(userId);
            int recordAdded = appointmentManagementDAO.addAppointment(appointmentsInfo);
            if (recordAdded == 1) {
                statusCode = SUCCESS;
            }
            else {
            statusCode = ERROR;
            }
        }
        return statusCode;
    }

    public Integer getAppointments_id() {
        return appointments_id;
    }

    public void setAppointments_id(Integer appointments_id) {
        this.appointments_id = appointments_id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "AddAction{" +
                "appointments_id=" + appointments_id +
                ", area='" + area + '\'' +
                ", date='" + date + '\'' +
                ", doctor_name='" + doctor_name + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
