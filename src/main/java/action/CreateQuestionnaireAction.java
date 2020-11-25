package action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entityStruct.Option;
import entityStruct.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.QuestionnaireManagementService;

@Component
public class CreateQuestionnaireAction extends ActionSupport {

    @Autowired
    QuestionnaireManagementService questionnaireManagementService;
    String userId;
    String questionnaireTitle;
    int questionNum;
    String questionContent[] = new String[100];
    String questionType[] = new String[100];
    String optionNum[] = new String[100];
    String optionContent[][] = new String[100][10];

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

    public String execute() {
        List<Question> questions = new ArrayList<Question>();
        for(int i = 1; i <= questionNum; i++) {
            Question question = new Question();
            question.setQuestionNo(i);
            question.setQuestionContent(questionContent[i]);
            question.setQuestionType(questionType[i]);
            if(!questionType[i].equals("简答题")){
                question.setOptionNum(Integer.parseInt(optionNum[i]));
            }
            else
                question.setOptionNum(0);
            List<Option> options = new ArrayList<Option>();
            for(int j = 0; j < question.getOptionNum(); j++) {
                Option option = new Option();
                option.setOptionContent(optionContent[i][j]);
                option.setOptionNo(j+1);
                options.add(option);
            }
            question.setOptionList(options);
            questions.add(question);
        }
        System.out.println(questionnaireTitle);
        userId = (String) ActionContext.getContext().getSession().get("userId");
        questionnaireManagementService.insert_New_Questionnaire(questionnaireTitle, questionNum, userId, questions);
        return SUCCESS;
    }
    
}