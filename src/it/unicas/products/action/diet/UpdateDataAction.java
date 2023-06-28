package it.unicas.products.action.diet;

import com.opensymphony.xwork2.ActionSupport;
import it.unicas.products.dao.dietManagementDAO;
import it.unicas.products.pojo.DietInfo;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class UpdateDataAction extends ActionSupport implements SessionAware {
    private SessionMap<String, Object> sessionMap;
    private Integer user_id;
    private String meal;
    private Integer carbs;
    private String datetime;
    private Integer diet_id;
    private DietInfo dietInfo;

    public String execute() {
        dietInfo = dietManagementDAO.getDietByID(diet_id);
        sessionMap.put("dietInfoToUpdate", dietInfo);

        if (dietInfo != null) {
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

    public DietInfo getDietInfo() {
        return dietInfo;
    }

    public void setDietInfo(DietInfo dietInfo) {
        this.dietInfo = dietInfo;
    }

    @Override
    public String toString() {
        return "UpdateDataAction{" +
                "sessionMap=" + sessionMap +
                ", user_id=" + user_id +
                ", meal='" + meal + '\'' +
                ", carbs=" + carbs +
                ", datetime='" + datetime + '\'' +
                ", diet_id=" + diet_id +
                ", dietInfo=" + dietInfo +
                '}';
    }
}