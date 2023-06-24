package it.unicas.products.action.diet;

import com.opensymphony.xwork2.ActionSupport;
import it.unicas.products.dao.dietManagementDAO;
import it.unicas.products.pojo.DietInfo;
import org.apache.struts2.ServletActionContext;


import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;

public class AddAction extends ActionSupport {
    private String meal;
    private Integer carbs;

    public String execute() {
        String statusCode = "";
        Integer userId = (Integer) ServletActionContext.getRequest().getSession().getAttribute("loggedInUserId");
        Formatter fmt = new Formatter();
        Calendar datetimeStr = Calendar.getInstance();
        String timeStr = String.valueOf(fmt.format("%tr", datetimeStr));

        if (userId != null){
            DietInfo dietInfo = new DietInfo(meal, carbs, timeStr);
            dietInfo.setMeal(meal);
            dietInfo.setCarbs(carbs);
            dietInfo.setUser_id(userId);

            int recordAdded = dietManagementDAO.addDiet(dietInfo);
            if (recordAdded == 1) {
                statusCode = SUCCESS;
            } else {
                statusCode = ERROR;
            }
        }

        return statusCode;
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
}
