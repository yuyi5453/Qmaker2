package action;

import java.util.ArrayList;
import java.util.List;

import entityStruct.Option;
import entityStruct.Question;
import service.QuestionnaireManagementService;

public class UpdateQuestionnaireAction extends ActionSupport {

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