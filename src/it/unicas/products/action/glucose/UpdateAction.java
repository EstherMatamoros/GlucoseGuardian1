package it.unicas.products.action.glucose;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import it.unicas.products.dao.glucoseManagementDAO;
import it.unicas.products.pojo.Glucose;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import java.sql.Timestamp;
import java.util.Map;

public class UpdateAction extends ActionSupport implements SessionAware {

	private Integer measurement;
	private String createdDate;
	private Integer user_id;
	private Timestamp timestamp;
	private Integer id;
	private SessionMap<String, Object> sessionMap;

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

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(SessionMap<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	@Override
	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap<String, Object>) map;
	}

	public String execute() {
		String statusCode = "";
		Integer userId = (Integer) ServletActionContext.getRequest().getSession().getAttribute("loggedInUserId");

		// Retrieve the glucose object from the session
		Glucose glucoseToUpdate = (Glucose) sessionMap.get("glucoseToUpdate");

		// Set the properties for updating
		glucoseToUpdate.setMeasurement(measurement);
		glucoseToUpdate.setCreatedDate(createdDate);
		glucoseToUpdate.setUser_id(userId);
		glucoseToUpdate.setTimestamp(timestamp);

		// Perform the update
		int recordUpdated = glucoseManagementDAO.updateGlucose(glucoseToUpdate, timestamp);

		if (recordUpdated == 1) {
			statusCode = "success";
		} else {
			statusCode = "error";
		}

		// Remove the glucose object from the session
		sessionMap.remove("glucoseToUpdate");

		return statusCode;
	}

	@Override
	public String toString() {
		return "UpdateAction{" +
				"measurement=" + measurement +
				", createdDate='" + createdDate + '\'' +
				", user_id=" + user_id +
				", timestamp=" + timestamp +
				", id=" + id +
				", sessionMap=" + sessionMap +
				'}';
	}
}