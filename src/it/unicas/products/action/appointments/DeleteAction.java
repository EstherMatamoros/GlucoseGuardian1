package it.unicas.products.action.appointments;

import com.opensymphony.xwork2.ActionSupport;
import it.unicas.products.dao.appointmentManagementDAO;

public class DeleteAction extends ActionSupport {

    private Integer appointments_id;

    public String execute() {
        String statusCode = "";

        int recordDeleted = appointmentManagementDAO.deleteAppointmentInfo(appointments_id);
        if (recordDeleted == 1) {
            statusCode = "success";
        } else {
            statusCode = "error";
        }
        return statusCode;
    }

    public Integer getAppointments_id() {
        return appointments_id;
    }

    public void setAppointments_id(Integer appointments_id) {
        this.appointments_id = appointments_id;
    }

    @Override
    public String toString() {
        return "DeleteAction{" +
                "appointments_id=" + appointments_id +
                '}';
    }
}
