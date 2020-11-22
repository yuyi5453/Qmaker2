package action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import service.OptionDetailService;
import service.QuesHeadInfoService;
import service.QuestionnaireDetailService;
import serviceImpl.OptionDetailServiceImpl;
import serviceImpl.QuesHeadInfoServiceImpl;
import serviceImpl.QuestionnaireDetailServiceImpl;

public class UpdateQuestionnaireAction extends ActionSupport{
	QuesHeadInfoService quesHeadInfoService;
	QuestionnaireDetailService questionnaireDetailService;
	OptionDetailService optionDetailService;
	
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
	public String execute(){
		Map session = ActionContext.getContext().getSession();
		UserID = (String) session.get("UserID");
		questionnaireId = (String) session.get("QuestionnaireId");
		quesHeadInfoService.update_QuestionnaireHeadInfo_By_QId(questionnaireId, title, questionNum);
		questionnaireDetailService.delete_Question_Detail_By_QId(questionnaireId);
		optionDetailService.delete_Option_Detail_By_QId(questionnaireId);
		for(int i = 1; i <= questionNum; i++){
			if(questionType[i].equals("¼ò´ðÌâ")){
				optionNum[i] = "0";
			}
			else{
				int j;
				for(j = 0; j < Integer.valueOf(optionNum[i]); j++){
					optionDetailService.insert_Option_Detail(Integer.parseInt(questionnaireId), i, j+1, option[i][j]);
					System.out.println(i +" "+ j +" " + option[i][j]);
				}
			}
			questionnaireDetailService.insert_Question_Detail(Integer.parseInt(questionnaireId), i, Question[i], questionType[i], Integer.valueOf(optionNum[i]), null, null);
		}
		
		return SUCCESS;
	}
	
	String UserID;
	String questionnaireId;
	String title;
	String questionnaireType;
	int questionNum;
	String [] Question = new String[100];
	String [] questionType = new String[100];
	String [][] option = new String[100][10];
	String [] optionNum = new String[100];
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getQuestionnaireType() {
		return questionnaireType;
	}
	public void setQuestionnaireType(String questionnaireType) {
		this.questionnaireType = questionnaireType;
	}
	public int getQuestionNum() {
		return questionNum;
	}
	public void setQuestionNum(int questionNum) {
		this.questionNum = questionNum;
	}
	public String[] getQuestion() {
		return Question;
	}
	public void setQuestion(String[] question) {
		Question = question;
	}
	public String[] getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String[] questionType) {
		this.questionType = questionType;
	}
	public String[][] getOption() {
		return option;
	}
	public void setOption(String[][] option) {
		this.option = option;
	}
	public String[] getOptionNum() {
		return optionNum;
	}
	public void setOptionNum(String[] optionNum) {
		this.optionNum = optionNum;
	}
	
	
}
