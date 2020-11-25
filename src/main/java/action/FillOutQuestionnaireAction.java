package action;

import com.opensymphony.xwork2.ActionSupport;
import service.AnswerService;

public class FillOutQuestionnaireAction extends ActionSupport {

    AnswerService answerService;
    String questionnaireId;
    String [] option4Question = new String[100];

    public AnswerService getAnswerService() {
        return answerService;
    }

    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

    public String getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(String questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public String[] getOption4Question() {
        return option4Question;
    }

    public void setOption4Question(String[] option4Question) {
        this.option4Question = option4Question;
    }

    public String execute() {
        System.out.println(questionnaireId);
        String answerSheetId = answerService.insert_New_AnswerSheet(questionnaireId);
        int i = 1;
        while(option4Question[i] != null){
            answerService.insert_Answer_Detail(answerSheetId, i, option4Question[i]);
            i++;
        }
        return SUCCESS;
    }

    
}