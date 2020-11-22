package action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class UpdatePaperAction extends UpdateQuestionnaireAction{
	
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
			questionnaireDetailService.insert_Question_Detail(Integer.parseInt(questionnaireId), i, Question[i], questionType[i], Integer.valueOf(optionNum[i]), standardAnswer[i], Integer.parseInt(score[i]));
		}
		
		return SUCCESS;
	}
	
	
	
	
	
	String [] standardAnswer = new String[100];
	String [] score = new String[100];
	
	public String[] getStandardAnswer() {
		return standardAnswer;
	}
	public void setStandardAnswer(String[] standardAnswer) {
		this.standardAnswer = standardAnswer;
	}
	public String[] getScore() {
		return score;
	}
	public void setScore(String[] score) {
		this.score = score;
	}
}
