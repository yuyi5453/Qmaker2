package daoImpl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.QuestionnaireHeadInfoDao;
import entity.QuestionnaireHeadInfo;
import org.springframework.beans.factory.annotation.Autowired;

public class QuestionnaireHeadInfoDaoImpl implements QuestionnaireHeadInfoDao{
	@Autowired
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List get_Published_Questionnaire_By_UId(String userId){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		List list = null;
		try{
			Query query = session.createQuery("from QuestionnaireHeadInfo where UserID='"+userId+"' and Published='yes'");
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		ts.commit();
		session.close();
		return list;
	}
	
	public List get_Unpublished_Questionnaire_By_UId(String userId){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		List list = null;
		try{
			Query query = session.createQuery("from QuestionnaireHeadInfo where UserID='"+userId+"' and Published='no'");
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		ts.commit();
		session.close();
		return list;
	}
	
	
	public List get_Questionnaire_By_QId(String questionnaireId){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		List list = null;
		try{
			Query query = session.createQuery("from QuestionnaireHeadInfo where QuestionnaireID='"+questionnaireId+"'");
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		ts.commit();
		session.close();
		return list;
	}
	
	public List get_Max_QId(){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		List list = null;
		Query query = session.createSQLQuery("select max(QuestionnaireID) from QuestionnaireHeadInfo");
		list = query.list();
		ts.commit();
		session.close();
		return list;
	}
	
	public void delete_QuestionnaireHeadInfo(QuestionnaireHeadInfo questionnaireHeadInfo){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		session.delete(questionnaireHeadInfo);
		ts.commit();
		session.close();
	}
	
	public void insert_New_Quesitonnaire(String questionnaireId, String userId, String title, int questionNum, Timestamp lastChangedTime, String status){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		QuestionnaireHeadInfo quesitonnaireHeadInfo = new QuestionnaireHeadInfo();
		//set...
		session.save(quesitonnaireHeadInfo);
		ts.commit();
		session.close();
	}
	
	public void update_Published(String questionnaireId, String status){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		try{
			QuestionnaireHeadInfo questionnaireHeadInfo= (QuestionnaireHeadInfo) session.load(QuestionnaireHeadInfo.class, questionnaireId);
			questionnaireHeadInfo.setStatus(status);
			session.update(questionnaireHeadInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		ts.commit();
		session.close();
	}
	
	public void update_Title(String questionnaireId,String new_title){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		try{
			QuestionnaireHeadInfo questionnaireHeadInfo= (QuestionnaireHeadInfo) session.load(QuestionnaireHeadInfo.class, questionnaireId);
			questionnaireHeadInfo.setTitle(new_title);
			session.update(questionnaireHeadInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		ts.commit();
		session.close();
	}
	
	public void update_questionNum(String questionnaireId,int new_questionNum){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		try{
			QuestionnaireHeadInfo questionnaireHeadInfo= (QuestionnaireHeadInfo) session.load(QuestionnaireHeadInfo.class, questionnaireId);
			questionnaireHeadInfo.setQuestionNum(new_questionNum);
			session.update(questionnaireHeadInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		ts.commit();
		session.close();
	}
	
	public void update_lastChangeTime(String questionnaireId, Timestamp lastChangedTime){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		try{
			QuestionnaireHeadInfo questionnaireHeadInfo= (QuestionnaireHeadInfo) session.load(QuestionnaireHeadInfo.class, questionnaireId);
			questionnaireHeadInfo.setLastChangedTime(lastChangedTime);
			session.update(questionnaireHeadInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		ts.commit();
		session.close();
	}
}
