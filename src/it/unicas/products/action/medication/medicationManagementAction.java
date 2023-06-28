package it.unicas.products.action.medication;

import com.opensymphony.xwork2.ActionSupport;
import it.unicas.products.dao.medicationManagementDAO;
import it.unicas.products.pojo.MedicationInfo;
import org.apache.struts2.ServletActionContext;

import java.text.SimpleDateFormat;
import java.util.List;

public class medicationManagementAction extends ActionSupport {
    private List<MedicationInfo> medicationInfos;
    private String  name;
    private Integer dose;
    private String treatment_for;
    private String date_started;
    private String date_end;
    private Integer user_id;
    private Integer id;

    public void initializeProducts() {
        System.out.println("****** Filter Data ******");
        System.out.println(name);
        System.out.println(dose);
        System.out.println(treatment_for);
        System.out.println(date_started);
        System.out.println(date_end);
        user_id = (Integer) ServletActionContext.getRequest().getSession().getAttribute("loggedInUserId"); // Assign the value to the class field
        medicationInfos = medicationManagementDAO.getAllMedications(name, dose, treatment_for, date_started, date_end, user_id);
    }

    public String execute() {
        initializeProducts();
        return "success";
    }

    public List<MedicationInfo> getMedicationInfos() {
        return medicationInfos;
    }

    public void setMedicationInfos(List<MedicationInfo> medicationInfos) {
        this.medicationInfos = medicationInfos;
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

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "medicationManagementAction{" +
                "medicationInfos=" + medicationInfos +
                ", name='" + name + '\'' +
                ", dose=" + dose +
                ", treatment_for='" + treatment_for + '\'' +
                ", date_started='" + date_started + '\'' +
                ", date_end='" + date_end + '\'' +
                ", user_id=" + user_id +
                ", id=" + id +
                '}';
    }
}
