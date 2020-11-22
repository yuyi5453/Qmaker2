package action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.UserDoc;
import org.springframework.beans.factory.annotation.Autowired;
import service.UserService;
import serviceImpl.UserServiceImpl;

public class LoginAction extends ActionSupport{
	
	private String UserID;
	private String Password;
	@Autowired
	UserService userService;
	
	public String execute(){
		int status;
		System.out.println(userService==null);
		status = userService.Login(UserID, Password);
		if(status == -2){
			return "UserNotExist";
		}
		else if(status == -1){
			return "WrongPassword";
		}
		else{
			UserDoc u = userService.serch_User(UserID);
			Map session4User = ActionContext.getContext().getSession();
			session4User.put("UserID", UserID);
			session4User.put("Password", Password);
			return SUCCESS;
		}

	}
	
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
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
