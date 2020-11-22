package service;

public interface AnswerService {
    
    public String insert_New_AnswerSheet(String questionnaireId);//添加答卷

    public void insert_Answer_Detail(String answerSheetId, int questionNo, String answer);//添加答案

    public void delete_AnswerSheet_By_QId(String questionnaireId);//删除答卷
}