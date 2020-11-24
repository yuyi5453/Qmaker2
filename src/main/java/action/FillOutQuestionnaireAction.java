package action;

import service.AnswerService;

public class FillOutQuestionnaireAction extends ActionSupport {

    AnswerService answerService;
    String questionnaireId;
    String [] option4Question = new String[100];

    public String execute() {
        String answerSheetId = answerService.insert_New_AnswerSheet(questionnaireId);
        int i = 1;
        while(option4Question[i] != null){
            answerService.insert_Answer_Detail(answerSheetId, i, option4Question[i]);
        }
        return SUCCESS;
    }

    
}