package action;

import service.UserService;
import serviceImpl.UserServiceImpl;

import com.opensymphony.xwork2.ActionSupport;



public class UserRegisterAction extends ActionSupport{
	private String UserID;
	private String Password;
	UserService userService;
	
	public String execute(){
		int status = userService.Create_New_Account(UserID, Password,"Student",1);
		System.out.println("finish execute");
		if(status == 0)
			return SUCCESS;
		else
			return "failure";
	}
	
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userid) {
		UserID = userid;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
