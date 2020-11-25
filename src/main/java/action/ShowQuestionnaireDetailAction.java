package action;

import java.util.List;

import entity.QuestionnaireHeadInfo;
import service.QuestionnaireManagementService;

public class ShowQuestionnaireDetailAction extends ActionSupport {
    
    QuestionnaireManagementService questionnaireManagementService;
    String questionnaireId;
    String questionnaireTitle;
    List questionnaireContent;

    public String execute() {
        questionnaireTitle = ((QuestionnaireHeadInfo) questionnaireManagementService.get_QuestionnaireHeadInfo_By_QId(questionnaireId).get(0)).getTitle();
        questionnaireContent = questionnaireManagementService.get_Questionnaire_By_QId(questionnaireId);
    }
}