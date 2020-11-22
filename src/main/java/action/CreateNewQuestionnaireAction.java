package action;

import java.util.Map;

import service.OptionDetailService;
import service.QuesHeadInfoService;
import service.QuestionnaireDetailService;
import serviceImpl.OptionDetailServiceImpl;
import serviceImpl.QuesHeadInfoServiceImpl;
import serviceImpl.QuestionnaireDetailServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CreateNewQuestionnaireAction extends ActionSupport{
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
		questionnaireType = (String) session.get("questionnaireType");
		questionnaireType = "default";//test
		questionnaireId = quesHeadInfoService.insert_New_Questionnaire(title,questionnaireType ,questionNum, UserID);
		
		
			
		int j = 1;
		while(Question[j] != null){
			System.out.println("test:"+Question[j]);
			System.out.println("test:"+optionNum[j]);
			j += 1;
		}
			
		for(int i = 1; i <= questionNum; i++){
			if(questionType[i].equals("简答题")){
				optionNum[i] = "0";
				//questionType[i] = "essay";
			}
			else{
				//if(questionType[i].equals("单选题"))
					//questionType[i] = "single";
				//else
					//questionType[i] = "multi";
				for(j = 0; j < Integer.valueOf(optionNum[i]); j++){
					optionDetailService.insert_Option_Detail(questionnaireId, i, j+1, option[i][j]);
					System.out.println(i +" "+ j +" " + option[i][j]);
				}
			}
			
			questionnaireDetailService.insert_Question_Detail(questionnaireId, i, Question[i], questionType[i], Integer.valueOf(optionNum[i]), null, null);
		}
		return SUCCESS;
	}
	
	
	
	String UserID;
	int questionnaireId;
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
