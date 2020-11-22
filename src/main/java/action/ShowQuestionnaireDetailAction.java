package action;

import java.util.List;

import service.QuestionnaireManagementService;

public class ShowQuestionnaireDetailAction extends ActionSupport {
    
    QuestionnaireManagementService questionnaireManagementService;
    String questionnaireId;
    String questionnaireTitle;
    List questionnaireContent;

    public String execute() {
        questionnaireContent = questionnaireManagementService.get_Questionnaire_By_QId(questionnaireId);
    }
}