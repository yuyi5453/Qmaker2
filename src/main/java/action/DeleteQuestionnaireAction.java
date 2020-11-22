package action;

import service.QuestionnaireManagementService;

public class DeleteQuestionnaireAction extends ActionSupport{
    
    QuestionnaireManagementService questionnaireManagementService;
    String questionnaireId;

    public String execute() {
        questionnaireManagementService.delete_Questionnaire_By_QId(questionnaireId);
    }
}