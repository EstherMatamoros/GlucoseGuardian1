package it.unicas.products.action.users;

import com.opensymphony.xwork2.ActionSupport;
import it.unicas.products.dao.usersManagementDAO;
import it.unicas.products.pojo.Users;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddAction extends ActionSupport {

    private String user_name;
    private String password;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String execute() {
        String statusCode = "";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String createdDateStr = formatter.format(new Date());
        Users users = new Users(user_name,password);
        int recordAdded = usersManagementDAO.addProduct(users);
        if (recordAdded == 1) {
            statusCode = SUCCESS;
        } else {
            statusCode = ERROR;
        }
        return statusCode;
    }
}
