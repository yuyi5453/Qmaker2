package dao;

import java.util.List;

public interface UserDocDao {

	public void insert_New_User(String UserID, String Password);
	
	public List select_User(String UserID);
}