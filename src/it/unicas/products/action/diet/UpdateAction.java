package it.unicas.products.action.diet;

import com.opensymphony.xwork2.ActionSupport;
import it.unicas.products.dao.dietManagementDAO;
import it.unicas.products.pojo.DietInfo;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import java.util.Map;

public class UpdateAction extends ActionSupport implements SessionAware {

	private Integer user_id;
	private String meal;
	private Integer carbs;
	private String datetime;
	private Integer diet_id;
	private SessionMap<String, Object> sessionMap;

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public Integer getCarbs() {
		return carbs;
	}

	public void setCarbs(Integer carbs) {
		this.carbs = carbs;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public Integer getDiet_id() {
		return diet_id;
	}

	public void setDiet_id(Integer diet_id) {
		this.diet_id = diet_id;
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
		DietInfo dietInfoToUpdate = (DietInfo) sessionMap.get("dietInfoToUpdate");
		dietInfoToUpdate.setMeal(meal);
		dietInfoToUpdate.setCarbs(carbs);
		dietInfoToUpdate.setDatetime(datetime);
		dietInfoToUpdate.setUser_id(userId);

		// Perform the update
		int recordUpdated = dietManagementDAO.updateDietInfo(dietInfoToUpdate);

		if (recordUpdated == 1) {
			statusCode = "success";
		} else {
			statusCode = "error";
		}

		// Remove the glucose object from the session
		sessionMap.remove("dietInfoToUpdate");

		return statusCode;
	}

	@Override
	public String toString() {
		return "UpdateAction{" +
				"user_id=" + user_id +
				", meal='" + meal + '\'' +
				", carbs=" + carbs +
				", datetime='" + datetime + '\'' +
				", diet_id=" + diet_id +
				", sessionMap=" + sessionMap +
				'}';
	}
}