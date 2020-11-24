package action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import entityStruct.Option;
import entityStruct.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.QuestionnaireManagementService;

@Component
public class UpdateQuestionnaireAction extends ActionSupport {

    public QuestionnaireManagementService getQuestionnaireManagementService() {
        return questionnaireManagementService;
    }

    public void setQuestionnaireManagementService(QuestionnaireManagementService questionnaireManagementService) {
        this.questionnaireManagementService = questionnaireManagementService;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public int getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(int questionNum) {
        this.questionNum = questionNum;
    }

    public String[] getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String[] questionContent) {
        this.questionContent = questionContent;
    }

    public String[] getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String[] questionType) {
        this.questionType = questionType;
    }

    public String[] getOptionNum() {
        return optionNum;
    }

    public void setOptionNum(String[] optionNum) {
        this.optionNum = optionNum;
    }

    public String[][] getOptionContent() {
        return optionContent;
    }

    public void setOptionContent(String[][] optionContent) {
        this.optionContent = optionContent;
    }

    @Autowired
    QuestionnaireManagementService questionnaireManagementService;
    String userId;
    String questionnaireId;
    String questionnaireTitle;
    int questionNum;
    String questionContent[] = new String[100];
    String questionType[] = new String[100];
    String optionNum[] = new String[100];
    String optionContent[][] = new String[100][10];

    public String execute(){
        List<Question> questions = new ArrayList<Question>();
        for(int i = 1; i <= questionNum; i++) {
            Question question = new Question();
            question.setQuestionNo(i);
            question.setQuestionContent(questionContent[i]);
            question.setQuestionType(questionType[i]);
            question.setOptionNum(Integer.parseInt(optionNum[i]));
            List<Option> options = new ArrayList<Option>();
            for(int j = 1; i <= Integer.parseInt(optionNum[i]); j++) {
                Option option = new Option();
                option.setOptionContent(optionContent[i][j]);
                option.setOptionNo(j);
                options.add(option);
            }
            questions.add(question);
        }
        questionnaireManagementService.update_Questionnaire_By_QId(questionnaireId, questionnaireTitle, questionNum, userId, questions);
        return SUCCESS;
    }
    
}