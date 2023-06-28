package it.unicas.products.action.appointments;

import com.opensymphony.xwork2.ActionSupport;
import it.unicas.products.dao.appointmentManagementDAO;
import it.unicas.products.pojo.AppointmentsInfo;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class UpdateDataAction extends ActionSupport implements SessionAware {
    private SessionMap<String, Object> sessionMap;
    private Integer appointments_id;
    private String area;
    private String date;
    private String doctor_name;
    private Integer user_id;
    private AppointmentsInfo appointmentsInfo;

    public String execute() {
        System.out.println("execute() in updateDataAction method called");
        appointmentsInfo = appointmentManagementDAO.getAppointmentByID(appointments_id);
        sessionMap.put("appointmentsInfoToUpdate", appointmentsInfo);

        if (appointmentsInfo != null) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
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

    public AppointmentsInfo getAppointmentsInfo() {
        return appointmentsInfo;
    }

    public void setAppointmentsInfo(AppointmentsInfo appointmentsInfo) {
        this.appointmentsInfo = appointmentsInfo;
    }

    @Override
    public String toString() {
        return "UpdateDataAction{" +
                "sessionMap=" + sessionMap +
                ", appointments_id=" + appointments_id +
                ", area='" + area + '\'' +
                ", date='" + date + '\'' +
                ", doctor_name='" + doctor_name + '\'' +
                ", user_id=" + user_id +
                ", appointmentsInfo=" + appointmentsInfo +
                '}';
    }
}