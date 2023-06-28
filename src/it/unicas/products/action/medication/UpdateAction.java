package it.unicas.products.action.medication;

import com.opensymphony.xwork2.ActionSupport;
import it.unicas.products.dao.exerciseManagementDAO;
import it.unicas.products.dao.medicationManagementDAO;
import it.unicas.products.pojo.MedicationInfo;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class UpdateAction extends ActionSupport implements SessionAware {
	private String  name;
	private Integer dose;
	private String treatment_for;
	private String date_started;
	private String date_end;
	private Integer id;
	private SessionMap<String, Object> sessionMap;


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
	@Override
	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap<String, Object>) map;
	}

	public String execute() {
		String statusCode = "";
		Integer userId = (Integer) ServletActionContext.getRequest().getSession().getAttribute("loggedInUserId");
		MedicationInfo medicationInfoToUpdate = (MedicationInfo) sessionMap.get("medicationInfoToUpdate");
		// Set the properties for updating
		medicationInfoToUpdate.setName(name);
		medicationInfoToUpdate.setDose(dose);
		medicationInfoToUpdate.setTreatment_for(treatment_for);
		medicationInfoToUpdate.setDate_started(date_started);
		medicationInfoToUpdate.setDate_end(date_end);
		medicationInfoToUpdate.setUser_id(userId);

		// Perform the update
		int recordUpdated = medicationManagementDAO.updateMedication(medicationInfoToUpdate);
		System.out.println(" exerciseManagementDAO.updateExerciseInfo(exerciseInfoToUpdate) : " + medicationInfoToUpdate);

		System.out.println(" Update Action exerciseInfo recordUpdated : " + recordUpdated);

		if (recordUpdated == 1) {
			statusCode = "success";
		} else {
			statusCode = "error";
		}

		// Remove the glucose object from the session
		sessionMap.remove("medicationInfoToUpdate");

		return statusCode;
	}

	@Override
	public String toString() {
		return "UpdateAction{" +
				"name='" + name + '\'' +
				", dose=" + dose +
				", treatment_for='" + treatment_for + '\'' +
				", date_started='" + date_started + '\'' +
				", date_end='" + date_end + '\'' +
				", id=" + id +
				'}';
	}
}
