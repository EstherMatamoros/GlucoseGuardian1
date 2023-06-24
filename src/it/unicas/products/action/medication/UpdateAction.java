package it.unicas.products.action.medication;

import com.opensymphony.xwork2.ActionSupport;
import it.unicas.products.dao.ProductManagementDAO;
import it.unicas.products.dao.medicationManagementDAO;
import it.unicas.products.pojo.MedicationInfo;
import it.unicas.products.pojo.Product;
import org.apache.struts2.ServletActionContext;

public class UpdateAction extends ActionSupport{
	private String  name;
	private Integer dose;
	private String treatment_for;
	private String date_started;
	private String date_end;
	
	public String execute() {
		String statusCode = "";

		MedicationInfo medicationInfo = new MedicationInfo(name, dose, treatment_for, date_started, date_end);
		int recordUpdated = medicationManagementDAO.updateMedication(medicationInfo);
		if (recordUpdated == 1) {
			statusCode = "success";
		} else {
			statusCode = "error";
		}
		return statusCode;
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

	@Override
	public String toString() {
		return "UpdateAction{" +
				"name='" + name + '\'' +
				", dose=" + dose +
				", treatment_for='" + treatment_for + '\'' +
				", date_started='" + date_started + '\'' +
				", date_end='" + date_end + '\'' +
				'}';
	}
}
