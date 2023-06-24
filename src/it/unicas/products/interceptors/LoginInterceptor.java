package it.unicas.products.interceptors;

import it.unicas.products.action.users.AddAction;
import it.unicas.products.action.users.userManagementAction;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import it.unicas.products.action.LoginAction;

public class LoginInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy() called");
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("init() called");
	}

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		Object user = ServletActionContext.getRequest().getSession().getAttribute("loggedinUser");
		if (user == null) {
			if (ai.getAction().getClass().equals(LoginAction.class)
					|| ai.getAction().getClass().equals(AddAction.class)
					|| ai.getAction().getClass().equals(userManagementAction.class)) {
				return ai.invoke();
			} else {
				return "input"; // Or any other result for unauthorized access
			}
		}
		return ai.invoke();
	}

}
