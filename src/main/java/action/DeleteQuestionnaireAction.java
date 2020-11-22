package action;

import com.opensymphony.xwork2.ActionSupport;
import service.QuestionnaireManagementService;

public class DeleteQuestionnaireAction extends ActionSupport {
    
    QuestionnaireManagementService questionnaireManagementService;
    String questionnaireId;

    public String execute() {
        questionnaireManagementService.delete_Questionnaire_By_QId(questionnaireId);
        return null;
    }
}