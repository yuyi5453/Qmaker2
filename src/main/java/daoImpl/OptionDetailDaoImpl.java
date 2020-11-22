package daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.OptionDetailDao;
import entity.OptionDetail;
import entity.OptionDetailId;
import org.springframework.beans.factory.annotation.Autowired;

public class OptionDetailDaoImpl implements OptionDetailDao{
	@Autowired
	SessionFactory sessionFactory;
	
	public List get_Option_Detail_By_QId_QNo(String questionnaireId, String questionNo){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		List list = null;
		try{
			Query query = session.createQuery("from OptionDetail where QuestionnaireID='"+questionnaireId+"' and QuestionNo='"+questionNo+"'");
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		ts.commit();
		session.close();
		return list;
	}
	
	public List get_Option_Detail_By_QId(String questionnaireId){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		List list = null;
		try{
			Query query = session.createQuery("from OptionDetail where QuestionnaireID='"+questionnaireId+"'");
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		ts.commit();
		session.close();
		return list;
	}
	
	public void insert_Option_Detail(String questionnaireId, int questionNo ,int optionNo, String optionContent){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		OptionDetailId optionDetailId = new OptionDetailId();
		optionDetailId.setQuestionnaireId(questionnaireId);
		optionDetailId.setQuestionNo(questionNo);
		optionDetailId.setOptionNo(optionNo);
		OptionDetail optionDetail = new OptionDetail();
		optionDetail.setId(optionDetailId);
		optionDetail.setOptionContent(optionContent);
		session.save(optionDetail);
		ts.commit();
		session.close();
	}
	
	public void delete_Option_Detail_By_QId_QNo_ONo(String questionnaireId, int questionNo, int optionNo){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		OptionDetailId optionDetailId = new OptionDetailId();
		optionDetailId.setQuestionnaireId(questionnaireId);
		optionDetailId.setQuestionNo(questionNo);
		optionDetailId.setOptionNo(optionNo);
		OptionDetail optionDetail = new OptionDetail();
		optionDetail.setId(optionDetailId);
		session.delete(optionDetail);
		ts.commit();
		session.close();
	}
	
	public void delete_Option_Detail(OptionDetail optionDetail){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		session.delete(optionDetail);
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
