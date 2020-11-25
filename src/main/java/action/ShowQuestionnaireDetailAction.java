package action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import entity.QuestionnaireHeadInfo;
import entityStruct.Question;
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


    public String getQuestionnaireTitle() {
        return questionnaireTitle;
    }

    public void setQuestionnaireTitle(String questionnaireTitle) {
        this.questionnaireTitle = questionnaireTitle;
    }

    @Autowired
    QuestionnaireManagementService questionnaireManagementService;
    String questionnaireId;
    String questionnaireTitle;
    List<Question> questionnaireContent;
    int questionNum;

    public int getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(int questionNum) {
        this.questionNum = questionNum;
    }

    public void setQuestionnaireContent(List<Question> questionnaireContent) {
        this.questionnaireContent = questionnaireContent;
    }

    public String execute() {
        System.out.println(questionnaireId);
        QuestionnaireHeadInfo questionnaireHeadInfo = (QuestionnaireHeadInfo)questionnaireManagementService.get_QuestionnaireHeadInfo_By_QId(questionnaireId).get(0);
        questionnaireTitle = questionnaireHeadInfo.getTitle();
        questionNum = questionnaireHeadInfo.getQuestionNum();
        questionnaireContent = questionnaireManagementService.get_Questionnaire_By_QId(questionnaireId);

        System.out.println(questionnaireContent.size());
        return "success";
    }
}