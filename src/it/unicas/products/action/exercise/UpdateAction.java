package it.unicas.products.action.exercise;

import com.opensymphony.xwork2.ActionSupport;
import it.unicas.products.dao.exerciseManagementDAO;
import it.unicas.products.pojo.ExerciseInfo;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class UpdateAction extends ActionSupport implements SessionAware {

	private Integer user_id;
	private Integer burned_calories;
	private Integer amount_time;
	private String date;
	private Integer exercise_id;
	private SessionMap<String, Object> sessionMap;

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getBurned_calories() {
		return burned_calories;
	}

	public void setBurned_calories(Integer burned_calories) {
		this.burned_calories = burned_calories;
	}

	public Integer getAmount_time() {
		return amount_time;
	}

	public void setAmount_time(Integer amount_time) {
		this.amount_time = amount_time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getExercise_id() {
		return exercise_id;
	}

	public void setExercise_id(Integer exercise_id) {
		this.exercise_id = exercise_id;
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
		ExerciseInfo exerciseInfoToUpdate = (ExerciseInfo) sessionMap.get("exerciseInfoToUpdate");

		// Set the properties for updating
		exerciseInfoToUpdate.setBurned_calories(burned_calories);
		exerciseInfoToUpdate.setAmount_time(amount_time);
		exerciseInfoToUpdate.setDate(date);
		exerciseInfoToUpdate.setUser_id(userId);

		// Perform the update
		int recordUpdated = exerciseManagementDAO.updateExerciseInfo(exerciseInfoToUpdate);
		System.out.println(" exerciseManagementDAO.updateExerciseInfo(exerciseInfoToUpdate) : " + exerciseInfoToUpdate);

		System.out.println(" Update Action exerciseInfo recordUpdated : " + recordUpdated);

		if (recordUpdated == 1) {
			statusCode = "success";
		} else {
			statusCode = "error";
		}

		// Remove the glucose object from the session
		sessionMap.remove("exerciseInfoToUpdate");

		return statusCode;
	}

	@Override
	public String toString() {
		return "UpdateAction{" +
				"user_id=" + user_id +
				", burned_calories=" + burned_calories +
				", amount_time=" + amount_time +
				", date='" + date + '\'' +
				", exercise_id=" + exercise_id +
				", sessionMap=" + sessionMap +
				'}';
	}
}