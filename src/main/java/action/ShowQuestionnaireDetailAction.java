package action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.QuestionnaireManagementService;

@Component
public class ShowQuestionnaireDetailAction extends ActionSupport {

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

    public List getQuestionnaireContent() {
        return questionnaireContent;
    }

    public void setQuestionnaireContent(List questionnaireContent) {
        this.questionnaireContent = questionnaireContent;
    }

    @Autowired
    QuestionnaireManagementService questionnaireManagementService;
    String questionnaireId;
    List questionnaireContent;

    public String execute() {
        System.out.println(questionnaireId);
//        questionnaireContent = questionnaireManagementService.get_Questionnaire_By_QId(questionnaireId);
        return "success";
    }
}