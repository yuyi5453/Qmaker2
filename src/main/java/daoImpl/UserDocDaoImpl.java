package daoImpl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.UserDocDao;
import entity.UserDoc;

public class UserDocDaoImpl implements UserDocDao{
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public void insert_New_User(String UserID, String Password){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		UserDoc user = new UserDoc();
		user.setUserId(UserID);
		user.setPassword(Password);
		try{
			session.save(user);
			System.out.println("save user");
		}catch(Exception e){
			e.printStackTrace();
		}
		ts.commit();
		session.close();
		System.out.println("close session");
	}
	
	public List select_User(String UserID){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		List list = null;
		try{
			Query query = session.createQuery("from UserDoc u where u.userId='"+UserID+"'");
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		ts.commit();
		session.close();
		return list;
	}
}