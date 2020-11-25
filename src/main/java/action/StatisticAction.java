package action;

import java.util.List;


import service.StatisticService;
import service.QuestionnaireManagementService;

import entity.QuestionnaireHeadInfo;

public class StatisticAction {
    
    StatisticService statisticService;
    QuestionnaireManagementService questionnaireManagementService;
    String questionnaireId;
    String questionnaireTitle;
    List questionnaireContent;

    public String execute() {
        questionnaireTitle = ((QuestionnaireHeadInfo) questionnaireManagementService.get_QuestionnaireHeadInfo_By_QId(questionnaireId).get(0)).getTitle();
        questionnaireContent = statisticService.getStatistics(questionnaireId);
        return SUCCESS;
    }
}