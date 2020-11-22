package action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.UserDoc;
import service.UserService;
import serviceImpl.UserServiceImpl;

public class SearchUserAction extends ActionSupport{
	UserService userService;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	public String execute(){
		System.out.println("execute search user:"+userId);
		UserDoc u = userService.serch_User(userId);
		if(u != null){
			Map session = ActionContext.getContext().getSession();
			int u_rank = (Integer) session.get("UserRank");
			System.out.println(u.getUserId()+" "+u.getPassword());
			return SUCCESS;
//			if(u_rank >= u.getUserRank()){
//
//				userType = u.getUserType();
//				return SUCCESS;
//			}
//			else{
//				return "failure";
//			}
			
		}
		else{
			userType = null;
			return "failure";
		}
		
	}
	
	String userId;
	String userType;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
}
