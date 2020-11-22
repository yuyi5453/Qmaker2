package serviceImpl;

import java.util.List;

import dao.QuestionnaireHeadInfoDao;
import entity.QuestionnaireHeadInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.PersonalIndexService;


@Component("personalIndexSerivce")
public class PersonalIndexServiceImpl implements PersonalIndexService {

    @Autowired
    private QuestionnaireHeadInfoDao questionnaireHeadInfoDao;

    @Override
    public List get_Published_Questionnaire_By_UId(String userId) {
        // TODO Auto-generated method stub
        List<QuestionnaireHeadInfo> questionnaireHeadInfos = (List<QuestionnaireHeadInfo>)questionnaireHeadInfoDao.get_Published_Questionnaire_By_UId(userId);
        return questionnaireHeadInfos;
    }

    @Override
    public List get_Unpublished_Questionnaire_By_UId(String userId) {
        // TODO Auto-generated method stub
        List<QuestionnaireHeadInfo> questionnaireHeadInfos = (List<QuestionnaireHeadInfo>)questionnaireHeadInfoDao.get_Unpublished_Questionnaire_By_UId(userId);
        return questionnaireHeadInfos;
    }
    
}