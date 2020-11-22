package service;

public interface UserService {
	
	public int create_New_Account(String userId, String password);//添加用户
	
	public int login(String userId, String password);//登录
	
}