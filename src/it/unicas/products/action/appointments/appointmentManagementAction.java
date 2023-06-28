package it.unicas.products.action.appointments;

import com.opensymphony.xwork2.ActionSupport;
import it.unicas.products.dao.appointmentManagementDAO;
import it.unicas.products.pojo.AppointmentsInfo;
import org.apache.struts2.ServletActionContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class appointmentManagementAction extends ActionSupport {
    private List<AppointmentsInfo> appointmentsInfos;
    private Integer appointments_id;
    private String area;
    private String date;
    private String doctor_name;
    private Integer user_id;

    public void initializeProducts() {
        System.out.println("****** Filter Data ******");
        System.out.println(area);
        System.out.println(doctor_name);
        System.out.println(date);
        String createdDateStr = "";
        user_id = (Integer) ServletActionContext.getRequest().getSession().getAttribute("loggedInUserId"); // Assign the value to the class field

        if(date != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
            createdDateStr = formatter.format(date);
        }
        appointmentsInfos = appointmentManagementDAO.getAllAppointments(area,createdDateStr,doctor_name, user_id);
    }

    public String execute() {
        initializeProducts();
        return "success";
    }

    public List<AppointmentsInfo> getAppointmentsInfos() {
        return appointmentsInfos;
    }

    public void setAppointmentsInfos(List<AppointmentsInfo> appointmentsInfos) {
        this.appointmentsInfos = appointmentsInfos;
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
        return "appointmentManagementAction{" +
                "appointmentsInfos=" + appointmentsInfos +
                ", appointments_id=" + appointments_id +
                ", area='" + area + '\'' +
                ", date='" + date + '\'' +
                ", doctor_name='" + doctor_name + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
