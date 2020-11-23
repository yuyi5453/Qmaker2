package action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.QuestionnaireManagementService;

@Component
public class ShowQuestionnaireDetailAction extends ActionSupport {

    @Autowired
    QuestionnaireManagementService questionnaireManagementService;
    String questionnaireId;
    String questionnaireTitle;
    List questionnaireContent;

    public String execute() {
        questionnaireContent = questionnaireManagementService.get_Questionnaire_By_QId(questionnaireId);
        return null;
    }
}