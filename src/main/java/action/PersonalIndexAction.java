package action;

import java.util.List;



import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.QuestionnaireHeadInfo;
import service.AnswerDetailService;
import service.AnswerSheetHeadInfoService;
import service.OptionDetailService;
import service.QuesHeadInfoService;
import service.QuestionnaireDetailService;
import service.StatisticService;
import serviceImpl.OptionDetailServiceImpl;
import serviceImpl.QuesHeadInfoServiceImpl;
import serviceImpl.QuestionnaireDetailServiceImpl;

public class PersonalIndexAction extends ActionSupport{
	public String execute(){
		System.out.println("UserID:"+UserID);
		Map session = ActionContext.getContext().getSession();
		UserID = (String) session.get("UserID");
		session.put("QuestionnaireStatus", "Published");
		System.out.println("UserID:"+UserID);
		QuestionnaireList =  quesHeadInfoService.get_Questionnair_By_UId(UserID);
		System.out.println("finish execute");
		return SUCCESS;
	}
	
	public String exec_Get_Unpublished_By_UId(){
		Map session = ActionContext.getContext().getSession();
		UserID = (String) session.get("UserID");
		session.put("QuestionnaireStatus", "Unpublished");
		System.out.println("UserID:"+UserID);
		QuestionnaireList = quesHeadInfoService.get_Unpublished_Questionnaire_By_UId(UserID);
		System.out.println("finish exec_Get_Unpublished_By_UId");
		return SUCCESS;
	}
	
	public String exec_Get_Filled_By_UId(){
		Map session = ActionContext.getContext().getSession();
		UserID = (String) session.get("UserID");
		session.put("QuestionnaireStatus", "Filled");
		QuestionnaireList = quesHeadInfoService.get_Filled_Questionnaire_By_UId(UserID);
		System.out.println("finish exec_Get_Filled_By_UId");
		return SUCCESS;
	}
	
	public String exec_Get_Others_By_UId(){
		Map session = ActionContext.getContext().getSession();
		UserID = (String) session.get("UserID");
		session.put("QuestionnaireStatus", "Others");
		QuestionnaireList = quesHeadInfoService.get_Others_Questionnaire_By_UId(UserID);
		System.out.println("exec_Get_Others_By_UId");
		return SUCCESS;
	}
	
	public String exec_delete(){
		System.out.println("Delete QuesId:"+QuestionnaireId);
		quesHeadInfoService.delete_Questionnaire_By_QId(QuestionnaireId);
		questionnaireDetailService.delete_Question_Detail_By_QId(QuestionnaireId);
		optionDetailService.delete_Option_Detail_By_QId(QuestionnaireId);
		answerSheetHeadInfoService.delete_AnswerSheet_By_QId(QuestionnaireId);
		return SUCCESS;
	}
	
	public String exec_show_detail(){
		System.out.println("Show detail QuesId:"+QuestionnaireId);
		Map session = ActionContext.getContext().getSession();
		session.put("QuestionnaireId", QuestionnaireId);
		QuestionnaireHeadInfo questionHeadInfo = (QuestionnaireHeadInfo) quesHeadInfoService.get_Questionnaire_By_QId(QuestionnaireId).get(0);
		QuestionnaireTitle = questionHeadInfo.getTitle();
		session.put("questionNum", String.valueOf(questionHeadInfo.getQuestionNum()));
		QuestionnaireContent = questionnaireDetailService.show_Questionnaire_Detail(QuestionnaireId);
		if(questionHeadInfo.getQuestionnaireType().equals("default")){
			System.out.println("questionnaire");
			return "questionnaire";
		}
		else{
			System.out.println("paper");
			return "paper";
		}
	}
	
	public String exec_show_answerSheet(){
		System.out.println("Show detail QuesId:"+QuestionnaireId);
		Map session = ActionContext.getContext().getSession();
		session.put("QuestionnaireId", QuestionnaireId);
		QuestionnaireHeadInfo questionHeadInfo = (QuestionnaireHeadInfo) quesHeadInfoService.get_Questionnaire_By_QId(QuestionnaireId).get(0);
		QuestionnaireTitle = questionHeadInfo.getTitle();
		session.put("questionNum", String.valueOf(questionHeadInfo.getQuestionNum()));
		QuestionnaireContent = questionnaireDetailService.show_AnswerSheet_Detail(QuestionnaireId);
		if(questionHeadInfo.getQuestionnaireType().equals("default")){
			System.out.println("questionnaire");
			return "questionnaire";
		}
		else{
			System.out.println("paper");
			return "paper";
		}
	}
	
	public String exec_Show_Statistics(){
		Map session = ActionContext.getContext().getSession();
		session.put("QuestionnaireId", QuestionnaireId);
		QuestionnaireHeadInfo questionHeadInfo = (QuestionnaireHeadInfo) quesHeadInfoService.get_Questionnaire_By_QId(QuestionnaireId).get(0);
		QuestionnaireTitle = questionHeadInfo.getTitle();
		session.put("questionNum", String.valueOf(questionHeadInfo.getQuestionNum()));
		QuestionnaireContent = statisticService.getStatistics(QuestionnaireId);
		if(questionHeadInfo.getQuestionnaireType().equals("default")){
			System.out.println("questionnaire");
			return "questionnaire";
		}
		else{
			System.out.println("paper");
			return "paper";
		}
	}
	
	public String exec_publish(){
		System.out.println("publish QuesId:"+QuestionnaireId);
//		quesHeadInfoService.publish_Questionnaire(QuestionnaireId);
		return SUCCESS;
	}
	
	String UserID;
	String QuestionnaireId;
	String QuestionnaireTitle;
	List QuestionnaireList = null;
	List QuestionnaireContent = null;
	QuesHeadInfoService quesHeadInfoService;
	QuestionnaireDetailService questionnaireDetailService;
	OptionDetailService optionDetailService;
	AnswerSheetHeadInfoService answerSheetHeadInfoService;
	AnswerDetailService answerDetailService;
	StatisticService statisticService;
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getQuestionnaireId() {
		return QuestionnaireId;
	}
	public void setQuestionnaireId(String questionnaireId) {
		QuestionnaireId = questionnaireId;
	}
	public QuesHeadInfoService getQuesHeadInfoService() {
		return quesHeadInfoService;
	}
	public void setQuesHeadInfoService(QuesHeadInfoService quesHeadInfoService) {
		this.quesHeadInfoService = quesHeadInfoService;
	}
	
	public QuestionnaireDetailService getQuestionnaireDetailService() {
		return questionnaireDetailService;
	}

	public void setQuestionnaireDetailService(
			QuestionnaireDetailService questionnaireDetailService) {
		this.questionnaireDetailService = questionnaireDetailService;
	}
	
	public OptionDetailService getOptionDetailService() {
		return optionDetailService;
	}

	public void setOptionDetailService(OptionDetailService optionDetailService) {
		this.optionDetailService = optionDetailService;
	}
	
	

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

	public List getQuestionnaireList() {
		return QuestionnaireList;
	}
	public void setQuestionnaireList(List questionnaireList) {
		QuestionnaireList = questionnaireList;
	}

	public List getQuestionnaireContent() {
		return QuestionnaireContent;
	}

	public void setQuestionnaireContent(List questionnaireContent) {
		QuestionnaireContent = questionnaireContent;
	}

	public String getQuestionnaireTitle() {
		return QuestionnaireTitle;
	}

	public void setQuestionnaireTitle(String questionnaireTitle) {
		QuestionnaireTitle = questionnaireTitle;
	}

	public StatisticService getStatisticService() {
		return statisticService;
	}

	public void setStatisticService(StatisticService statisticService) {
		this.statisticService = statisticService;
	}
	
}
