package dao;

import java.util.List;

public interface AnswerDetailDao {

	public void insert_AnswerDetail(String answerSheetId, int questionNo, String answer);
	
	public List get_AnswerDetail_By_AId(String answerSheetId);
	
	public void delete_AnswerDetail_By_AId(String answerSheetId);
	
	public int count_AnswerDetail_By_QId_QNo_ONo(String questionnaireId, int questionNo, int optionNo);
}
