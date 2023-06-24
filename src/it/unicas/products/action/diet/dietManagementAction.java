package it.unicas.products.action.diet;

import com.opensymphony.xwork2.ActionSupport;
import it.unicas.products.dao.dietManagementDAO;
import it.unicas.products.pojo.DietInfo;
import org.apache.struts2.ServletActionContext;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

public class dietManagementAction extends ActionSupport {

    private List<DietInfo> dietInfos;
    private String meal;
    private Integer carbs;
    private Date datetime;

    private Integer user_id;

    public void initializeProducts() {
        System.out.println("****** Filter Data ******");
        System.out.println(meal);
        System.out.println(carbs);
        System.out.println(datetime);
        String timeStr = "";
        Integer user_id = (Integer) ServletActionContext.getRequest().getSession().getAttribute("loggedInUserId");

        if(datetime != null) {
            Formatter fmt = new Formatter();
            Calendar datetimeStr = Calendar.getInstance();
            timeStr = String.valueOf(fmt.format("%tr", datetimeStr));
        }
        dietInfos = dietManagementDAO.getAllDiet(meal, carbs, timeStr, user_id);
    }

    public String execute() {
        initializeProducts();
        return "success";
    }

    public List<DietInfo> getDietInfos() {
        return dietInfos;
    }

    public void setDietInfos(List<DietInfo> dietInfos) {
        this.dietInfos = dietInfos;
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

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "dietManagementAction{" +
                "dietInfos=" + dietInfos +
                ", meal='" + meal + '\'' +
                ", carbs=" + carbs +
                ", datetime=" + datetime +
                ", user_id=" + user_id +
                '}';
    }
}
