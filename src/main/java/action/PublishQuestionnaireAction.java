package action;

import service.QuestionnaireManagementService;

public class PublishQuestionnaireAction extends ActionSupport {

    @Autowired
    QuestionnaireManagementService questionnaireManagementService;
    String questionnaireId;

    public String execute() {
        questionnaireManagementService.publish_Questionnaire(questionnaireId);
        return SUCCESS;
    }

}