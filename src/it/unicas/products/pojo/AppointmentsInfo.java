package it.unicas.products.pojo;

public class AppointmentsInfo {
    private Integer appointments_id;
    private String area;
    private String date;
    private String doctor_name;
    private Integer user_id;

    public AppointmentsInfo(String area, String date, String doctor_name) {
        this.area = area;
        this.date = date;
        this.doctor_name = doctor_name;
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
        return "AppointmentsInfo{" +
                "appointments_id=" + appointments_id +
                ", area='" + area + '\'' +
                ", date='" + date + '\'' +
                ", doctor_name='" + doctor_name + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
