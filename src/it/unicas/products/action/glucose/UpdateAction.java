package it.unicas.products.action.glucose;

import com.opensymphony.xwork2.ActionSupport;
import it.unicas.products.dao.ProductManagementDAO;
import it.unicas.products.dao.glucoseManagementDAO;
import it.unicas.products.pojo.Glucose;
import it.unicas.products.pojo.Product;

import java.sql.SQLException;

public class UpdateAction extends ActionSupport{

	private Integer measurement;
	private String createdDate;
	private String errorMessage;

	public String execute() {
		String statusCode = "";

		Glucose glucose = new Glucose(measurement, createdDate);
		int recordUpdated = glucoseManagementDAO.updateGlucose(glucose);

		if (recordUpdated == 1) {
			statusCode = "success";
		} else {
			statusCode = "error";
			errorMessage = "Failed to update glucose measurement.";
		}

		return statusCode;
	}

	public Integer getMeasurement() {
		return measurement;
	}

	public void setMeasurement(Integer measurement) {
		this.measurement = measurement;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "UpdateAction{" +
				"measurement=" + measurement +
				", createdDate='" + createdDate + '\'' +
				", errorMessage='" + errorMessage + '\'' +
				'}';
	}
}
