package action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class CreateNewPaperAction extends CreateNewQuestionnaireAction{
	
	
	public String execute(){
		
		Map session = ActionContext.getContext().getSession();
		UserID = (String) session.get("UserID");
		questionnaireType = "paper";
		questionnaireId = quesHeadInfoService.insert_New_Questionnaire(title,questionnaireType ,questionNum, UserID);

		int j = 1;
		while(Question[j] != null){
			System.out.println("test:"+Question[j]);
			System.out.println("test:"+optionNum[j]);
			j += 1;
		}
			
		for(int i = 1; i <= questionNum; i++){
			if(questionType[i].equals("¼ò´ðÌâ")){
				optionNum[i] = "0";
			}
			else{
				for(j = 0; j < Integer.valueOf(optionNum[i]); j++){
					optionDetailService.insert_Option_Detail(questionnaireId, i, j+1, option[i][j]);
					System.out.println(i +" "+ j +" " + option[i][j]);
				}
			}
			
			questionnaireDetailService.insert_Question_Detail(questionnaireId, i, Question[i], questionType[i], Integer.valueOf(optionNum[i]), standardAnswer[i], Integer.parseInt(score[i]));
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
