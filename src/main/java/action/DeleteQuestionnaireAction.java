package action;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.QuestionnaireManagementService;

@Component
public class DeleteQuestionnaireAction extends ActionSupport {

    @Autowired
    QuestionnaireManagementService questionnaireManagementService;
    String questionnaireId;

    public String execute() {
        questionnaireManagementService.delete_Questionnaire_By_QId(questionnaireId);
        return null;
    }
}