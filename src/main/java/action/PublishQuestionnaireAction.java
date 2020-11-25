package action;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.QuestionnaireManagementService;

@Component
public class PublishQuestionnaireAction extends ActionSupport {

    @Autowired
    QuestionnaireManagementService questionnaireManagementService;

    public QuestionnaireManagementService getQuestionnaireManagementService() {
        return questionnaireManagementService;
    }

    public void setQuestionnaireManagementService(QuestionnaireManagementService questionnaireManagementService) {
        this.questionnaireManagementService = questionnaireManagementService;
    }

    public String getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(String questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    String questionnaireId;

    public String execute() {
        questionnaireManagementService.publish_Questionnaire(questionnaireId);
        return SUCCESS;
    }

}