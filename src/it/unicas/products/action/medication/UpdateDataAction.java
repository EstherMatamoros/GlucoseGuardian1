package it.unicas.products.action.medication;

import com.opensymphony.xwork2.ActionSupport;
import it.unicas.products.dao.medicationManagementDAO;
import it.unicas.products.pojo.MedicationInfo;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import java.util.Map;

public class UpdateDataAction extends ActionSupport implements SessionAware {
    private SessionMap<String, Object> sessionMap;
    private String  name;
    private Integer dose;
    private String treatment_for;
    private String date_started;
    private String date_end;
    private Integer id;
    private MedicationInfo medicationInfo;


    public String execute() {
        medicationInfo = medicationManagementDAO.getMedicationByID(id);
        sessionMap.put("medicationInfoToUpdate", medicationInfo);

        if (medicationInfo != null) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDose() {
        return dose;
    }

    public void setDose(Integer dose) {
        this.dose = dose;
    }

    public String getTreatment_for() {
        return treatment_for;
    }

    public void setTreatment_for(String treatment_for) {
        this.treatment_for = treatment_for;
    }

    public String getDate_started() {
        return date_started;
    }

    public void setDate_started(String date_started) {
        this.date_started = date_started;
    }

    public String getDate_end() {
        return date_end;
    }

    public void setDate_end(String date_end) {
        this.date_end = date_end;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MedicationInfo getMedicationInfo() {
        return medicationInfo;
    }

    public void setMedicationInfo(MedicationInfo medicationInfo) {
        this.medicationInfo = medicationInfo;
    }

    @Override
    public String toString() {
        return "UpdateDataAction{" +
                "sessionMap=" + sessionMap +
                ", name='" + name + '\'' +
                ", dose=" + dose +
                ", treatment_for='" + treatment_for + '\'' +
                ", date_started='" + date_started + '\'' +
                ", date_end='" + date_end + '\'' +
                ", id=" + id +
                ", medicationInfo=" + medicationInfo +
                '}';
    }
}