package daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.QuestionDetailDao;
import entity.QuestionDetail;
import entity.QuestionDetailId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("questionDetailDao")
public class QuestionDetailDaoImpl implements QuestionDetailDao{
	@Autowired
	SessionFactory sessionFactory;
	
	public List get_question_detail(String QuestionnaireId){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		List list = null;
		try{
			Query query = session.createQuery("from QuestionDetail where QuestionnaireID='"+QuestionnaireId+"'");
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		ts.commit();
		session.close();
		return list;
	}
	
	public List get_question_By_QId_QNo(String questionnaireId, int questionNo){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		List list = null;
		try{
			Query query = session.createQuery("from QuestionDetail where QuestionnaireID='"+questionnaireId+"' and QuestionNo='"+questionNo+"'");
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		ts.commit();
		session.close();
		return list;
	}
	
	public void insert_question_detail(String questionnaireId, int questionNo, String questionContent, String questionType, int optionNum){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		QuestionDetailId questionDetailId = new QuestionDetailId();
		questionDetailId.setQuestionnaireId(questionnaireId);
		questionDetailId.setQuestionNo(questionNo);
		QuestionDetail questionDetail = new QuestionDetail();
		questionDetail.setId(questionDetailId);
		questionDetail.setQuestionContent(questionContent);
		questionDetail.setQuestionType(questionType);
		questionDetail.setOptionNum(optionNum);
		session.save(questionDetail);
		ts.commit();
		session.close();
	}
	
	public void delete_Qustion_Detail_By_QId(String questionnaireId){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("delete from QuestionDetail where QuestionnaireId='"+questionnaireId+"'");
		query.executeUpdate();
		ts.commit();
		session.close();
	}
	
	public void delete_Qustion_Detail(QuestionDetail questionDetail){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		session.delete(questionDetail);
		ts.commit();
		session.close();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
