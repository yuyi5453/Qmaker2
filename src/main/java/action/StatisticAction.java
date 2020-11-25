package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.QuestionnaireHeadInfo;
import entityStruct.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.QuestionnaireManagementService;
import service.StatisticService;

import java.util.List;

@Component
public class StatisticAction extends ActionSupport {

    @Autowired
    StatisticService statisticService;
    @Autowired
    QuestionnaireManagementService questionnaireManagementService;
    String questionnaireId;
    String questionnaireTitle;
    List<Question> questionnaireContent;

    public String execute() {
        questionnaireTitle = ((QuestionnaireHeadInfo)questionnaireManagementService.get_QuestionnaireHeadInfo_By_QId(questionnaireId).get(0)).getTitle();
        questionnaireContent = statisticService.getStatistics(questionnaireId);
        return SUCCESS;
    }

    public StatisticService getStatisticService() {
        return statisticService;
    }

    public void setStatisticService(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

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

    public String getQuestionnaireTitle() {
        return questionnaireTitle;
    }

    public void setQuestionnaireTitle(String questionnaireTitle) {
        this.questionnaireTitle = questionnaireTitle;
    }

    public List<Question> getQuestionnaireContent() {
        return questionnaireContent;
    }

    public void setQuestionnaireContent(List<Question> questionnaireContent) {
        this.questionnaireContent = questionnaireContent;
    }
}
