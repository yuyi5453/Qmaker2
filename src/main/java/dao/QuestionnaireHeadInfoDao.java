package dao;

import java.sql.Timestamp;
import java.util.List;

import entity.QuestionnaireHeadInfo;

public interface QuestionnaireHeadInfoDao {
	
	public List get_Published_Questionnaire_By_UId(String UserID);
	
	public List get_Unpublished_Questionnaire_By_UId(String UserID);
	
	public List get_Questionnaire_By_QId(String questionnaireId);
	
	public List get_Max_QId();

	public void delete_QuestionnaireHeadInfo(QuestionnaireHeadInfo quesitonnaireHeadInfo);
	
	public void insert_New_Quesitonnaire(String questionnaireId, String userId, String title, int questionNum, Timestamp lastChangedTime, String status);
	
	public void update_Published(String questionnaireId, String status);
	
	public void update_Title(String questionnaireId, String new_title);
	
	public void update_questionNum(String questionnaireId, int new_questionNum);
	
	public void update_lastChangeTime(String questionnaireId, Timestamp lastChangedTime);
}