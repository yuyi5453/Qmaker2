package service;

import entityStruct.Question;

import java.util.List;

public interface QuestionnaireManagementService {
    
    public List get_Questionnaire_By_QId(String questionnaireId);//获取问卷内容

    public String insert_New_Questionnaire(String title, int questionNum, String userId, List<Question> questions);//新建问卷

    public void delete_Questionnaire_By_QId(String questionnaireId);//删除问卷

    public void update_QuestionnaireHeadInfo_By_QId(String questionnaireId, String title, int questionNum);//更新问卷头信息

    public void update_Questionnaire_By_QId(String questionnaireId, String title, int questionNum, String userId, List<Question> questions);//更新问卷内容

    public void  publish_Questionnaire(String questionnaireId);
}