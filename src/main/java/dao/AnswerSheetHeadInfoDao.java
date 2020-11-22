package dao;

import java.util.List;

public interface AnswerSheetHeadInfoDao {
	
	public List get_Max_AnswerSheetId();
	
	public void insert_New_AnswerSheet(String answerSheetId, String questionnaireId);
	
	public void delete_AnswerSheet_By_QId(String questionnaireId);
	
	public List get_AnswerSheetHeadInfo_By_QId(String questionnaireId);
}
