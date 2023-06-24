package it.unicas.products.action.users;

import com.opensymphony.xwork2.ActionSupport;
import it.unicas.products.dao.usersManagementDAO;
import it.unicas.products.pojo.Users;

import java.text.SimpleDateFormat;
import java.util.List;

public class userManagementAction extends ActionSupport {


    private List<Users> users;

    private String user_name;

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void initializeProducts() {
        System.out.println("****** Filter Data ******");
        System.out.println(user_name);
        users = usersManagementDAO.getAllUsers(user_name);
    }

    public String execute() {
        initializeProducts();
        return "success";
    }
}
