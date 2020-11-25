package daoImpl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.AnswerDetailDao;
import entity.AnswerDetail;
import entity.AnswerDetailId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("answerDetailDao")
public class AnswerDetailDaoImpl implements AnswerDetailDao{
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void insert_AnswerDetail(String answerSheetId, int questionNo, String answer){
		AnswerDetailId answerDetailId = new AnswerDetailId();
		answerDetailId.setAnswerSheetId(answerSheetId);
		answerDetailId.setQuestionNo(questionNo);
		AnswerDetail answerDetail = new AnswerDetail();
		answerDetail.setId(answerDetailId);
		answerDetail.setAnswer(answer);
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		try {
			session.save(answerDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ts.commit();
		session.close();
	}
	public List get_AnswerDetail_By_AId(String answerSheetId){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		List list = null;
		try{
			Query query = session.createQuery("from AnswerDetail where AnswerSheetID='"+answerSheetId+"'");
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		ts.commit();
		session.close();
		return list;
	}
	
	public int count_AnswerDetail_By_QId_QNo_ONo(String questionnaireId, int questionNo, int optionNo){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		int count = 0;
		try{
			 Query query = session.createSQLQuery("select count(*) from AnswerDetail where AnswerSheetID in "
			 		+ "(select AnswerSheetID from AnswerSheetHeadInfo where QuestionnaireID = '"+questionnaireId+"') "
			 		+ "and Answer like '%"+optionNo+"%' and QuestionNo = '"+questionNo+"'");
			 count = Integer.valueOf(query.list().get(0).toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		ts.commit();
		session.close();
		return count;
	}
	
	public void delete_AnswerDetail_By_AId(String answerSheetId){
		AnswerDetailId answerDetailId = new AnswerDetailId();
		answerDetailId.setAnswerSheetId(answerSheetId);
		AnswerDetail answerDetail = new AnswerDetail();
		answerDetail.setId(answerDetailId);
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		try {
			session.delete(answerDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ts.commit();
		session.close();
	}
}
