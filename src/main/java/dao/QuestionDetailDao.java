package dao;

import java.util.List;

import entity.QuestionDetail;

public interface QuestionDetailDao {

	public List get_question_detail(String questionnaireId);
	
	public List get_question_By_QId_QNo(String questionnaireId, int questionNo);
	
	public void insert_question_detail(String questionnaireId, int questionNo, String questionContent, String questionType, int optionNum);
	
	public void delete_Qustion_Detail_By_QId(String questionnaireId);
	
	public void delete_Qustion_Detail(QuestionDetail questionDetail);
	
	
}
