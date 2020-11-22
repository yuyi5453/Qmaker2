package serviceImpl;

import dao.AnswerDetailDao;
import dao.AnswerSheetHeadInfoDao;
import entity.AnswerSheetHeadInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.AnswerService;

import java.util.UUID;

@Component("answerServiceImpl")
public class AnswerServiceImpl implements AnswerService{

    @Autowired
    private AnswerSheetHeadInfoDao answerSheetHeadInfoDao;
    private AnswerDetailDao answerDetailDao;
    
    @Override
    public String insert_New_AnswerSheet(String questionnaireId) {
        // TODO Auto-generated method stub
        String answerSheetId = UUID.randomUUID().toString();
        answerSheetHeadInfoDao.insert_New_AnswerSheet(answerSheetId, questionnaireId);
        return null;
    }

    @Override
    public void insert_Answer_Detail(String answerSheetId, int questionNo, String answer) {
        // TODO Auto-generated method stub
        answerDetailDao.insert_AnswerDetail(answerSheetId, questionNo, answer);

    }

    @Override
    public void delete_AnswerSheet_By_QId(String questionnaireId) {
        // TODO Auto-generated method stub
        String answerSheetId = ((AnswerSheetHeadInfo) answerSheetHeadInfoDao.get_AnswerSheetHeadInfo_By_QId(questionnaireId).get(0)).getId().getAnswerSheetId();
        answerSheetHeadInfoDao.delete_AnswerSheet_By_QId(questionnaireId);
        answerDetailDao.delete_AnswerDetail_By_AId(answerSheetId);

    }
    
}