package action;

import java.util.Map;

import service.AnswerDetailService;
import service.AnswerSheetHeadInfoService;
import service.QuestionnaireDetailService;
import serviceImpl.AnswerDetailServiceImpl;
import serviceImpl.AnswerSheetHeadInfoServiceImpl;
import serviceImpl.QuestionnaireDetailServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SubmitAnswerSheetAction extends ActionSupport{
	AnswerSheetHeadInfoService answerSheetHeadInfoService;
	AnswerDetailService answerDetailService;
	QuestionnaireDetailService questionnaireDetailService;
	public AnswerSheetHeadInfoService getAnswerSheetHeadInfoService() {
		return answerSheetHeadInfoService;
	}
	public void setAnswerSheetHeadInfoService(
			AnswerSheetHeadInfoService answerSheetHeadInfoService) {
		this.answerSheetHeadInfoService = answerSheetHeadInfoService;
	}
	public AnswerDetailService getAnswerDetailService() {
		return answerDetailService;
	}
	public void setAnswerDetailService(AnswerDetailService answerDetailService) {
		this.answerDetailService = answerDetailService;
	}
	public QuestionnaireDetailService getQuestionnaireDetailService() {
		return questionnaireDetailService;
	}
	public void setQuestionnaireDetailService(
			QuestionnaireDetailService questionnaireDetailService) {
		this.questionnaireDetailService = questionnaireDetailService;
	}
	public String execute(){
		Map session = ActionContext.getContext().getSession();
		userId = (String) session.get("UserID");
		questionnaireId = (String) session.get("QuestionnaireId");
		answerSheetId = answerSheetHeadInfoService.insert_New_AnswerSheet(questionnaireId, userId);
		int i = 1;
		while(Option4Question[i] != null){
			System.out.println("Answer for question "+i+":"+Option4Question[i]);
			String standardAnswer = questionnaireDetailService.get_StandardAnswer_By_QId_QNo(questionnaireId, i);
			int score = questionnaireDetailService.get_Score_By_QId_QNo(questionnaireId, i);
			if(Option4Question[i].equals(standardAnswer)){
				this.score = score;
			}
			else{
				this.score = 0;
			}
			answerDetailService.insert_Answer_Detail(answerSheetId, i, Option4Question[i],this.score);
			i += 1;
		}
		return SUCCESS;
	}
	String [] Option4Question = new String[20];
	int answerSheetId;
	String questionnaireId;
	String userId;
	Integer score;
	
	public String[] getOption4Question() {
		return Option4Question;
	}
	public void setOption4Question(String[] option4Question) {
		Option4Question = option4Question;
	}
	
}
