package it.unicas.products.action.users;

import com.opensymphony.xwork2.ActionSupport;
import it.unicas.products.dao.usersManagementDAO;
import it.unicas.products.pojo.Users;

public class UpdateUserAction extends ActionSupport {
	private String user_name;
	private String password;


	public String execute() {
		Users users = new Users(user_name, password);
		int recordUpdated = usersManagementDAO.updateUser(users);
		if (recordUpdated == 1) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	@Override
	public void validate() {
		// Perform validation on user_name and password fields
		if (user_name == null || user_name.trim().isEmpty()) {
			addFieldError("user_name", "Username is required.");
		}
		if (password == null || password.trim().isEmpty()) {
			addFieldError("password", "Password is required.");
		}
	}

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

	@Override
	public String toString() {
		return "UpdateUserAction{" +
				"user_name='" + user_name + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
