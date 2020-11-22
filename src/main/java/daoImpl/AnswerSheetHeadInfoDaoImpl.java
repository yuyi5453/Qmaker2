package daoImpl;

import java.util.List;

import entity.AnswerSheetHeadInfoId;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.AnswerSheetHeadInfoDao;
import entity.AnswerSheetHeadInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("answerSheetHeadInfoDao")
public class AnswerSheetHeadInfoDaoImpl implements AnswerSheetHeadInfoDao{
	@Autowired
	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List get_Max_AnswerSheetId(){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		List list = null;
		try {
			Query query = session.createSQLQuery("select max(AnswerSheetID) from AnswerSheetHeadInfo");
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ts.commit();
		session.close();
		return list;
	}
	public void insert_New_AnswerSheet(String answerSheetId, String questionnaireId){
		AnswerSheetHeadInfo answerSheetHeadInfo = new AnswerSheetHeadInfo();
		AnswerSheetHeadInfoId answerSheetHeadInfoId = new AnswerSheetHeadInfoId();
		answerSheetHeadInfoId.setAnswerSheetId(answerSheetId);
		answerSheetHeadInfoId.setQuestionnaireId(questionnaireId);
		answerSheetHeadInfo.setId(answerSheetHeadInfoId);
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		try {
			session.save(answerSheetHeadInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ts.commit();
		session.close();
	}
	
	public void delete_AnswerSheet_By_QId(String questionnaireId){
		AnswerSheetHeadInfo answerSheetHeadInfo = new AnswerSheetHeadInfo();
		AnswerSheetHeadInfoId answerSheetHeadInfoId = new AnswerSheetHeadInfoId();
		answerSheetHeadInfoId.setQuestionnaireId(questionnaireId);
		answerSheetHeadInfo.setId(answerSheetHeadInfoId);
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		try {
			session.delete(answerSheetHeadInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ts.commit();
		session.close();
	}
	
	public List get_AnswerSheetHeadInfo_By_QId(String questionnaireId){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		List list = null;
		try {
			Query query = session.createQuery("from AnswerSheetHeadInfo where QuestionnaireId='"+questionnaireId+"'");
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ts.commit();
		session.close();
		return list;
	}
	
}
