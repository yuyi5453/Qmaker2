package serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import dao.AnswerDetailDao;
import dao.AnswerSheetHeadInfoDao;
import dao.OptionDetailDao;
import dao.QuestionDetailDao;
import dao.QuestionnaireHeadInfoDao;
import entity.OptionDetail;
import entity.QuestionDetail;
import entityStruct.Option;
import entityStruct.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.StatisticService;

@Component("statisticService")
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private QuestionnaireHeadInfoDao questionnaireHeadInfoDao;
    @Autowired
	private QuestionDetailDao questionDetailDao;
    @Autowired
	private OptionDetailDao optionDetailDao;
    @Autowired
	private AnswerSheetHeadInfoDao answerSheetHeadInfoDao;
    @Autowired
	private AnswerDetailDao answerDetailDao;

    @Override
    public List getStatistics(String questionnaireId) {
        // TODO Auto-generated method stub
        Map session = ActionContext.getContext().getSession();
		String userId = (String) session.get("userId");
		List Ques_list = questionDetailDao.get_question_detail(questionnaireId);
		Iterator Ques_list_iter = Ques_list.iterator();
		List questionnaire = new ArrayList<Question>();
		while(Ques_list_iter.hasNext()){
			QuestionDetail questionDetail = (QuestionDetail)Ques_list_iter.next();
			Question q = new Question();
			q.setQuestionnaireId(questionDetail.getId().getQuestionnaireId());
			q.setQuestionNo(questionDetail.getId().getQuestionNo());
			q.setQuestionContent(questionDetail.getQuestionContent().trim());
			q.setQuestionType(questionDetail.getQuestionType().trim());
			
			if(!questionDetail.getQuestionType().trim().equals("essay")){
				q.setOptionNum(questionDetail.getOptionNum());
				String QuestionNo = Integer.toString(q.getQuestionNo());
				List Option_list =  optionDetailDao.get_Option_Detail_By_QId_QNo(questionnaireId, QuestionNo);
				//q.setOptionList(Option_list);
				List Opt_list = new ArrayList<Option>();
				Iterator Option_list_iter = Option_list.iterator();
				while(Option_list_iter.hasNext()){
					OptionDetail optionDetail = (OptionDetail) Option_list_iter.next();
					Option option = new Option();
					option.setQuestionnaireId(optionDetail.getId().getQuestionnaireId());
					option.setQuestionNo(q.getQuestionNo());
					option.setOptionNo(optionDetail.getId().getOptionNo());
					option.setOptionContent(optionDetail.getOptionContent());
					int count = answerDetailDao.count_AnswerDetail_By_QId_QNo_ONo(option.getQuestionnaireId(), option.getQuestionNo(), option.getOptionNo());
					option.setStatistic(count);
					Opt_list.add(option);
				}
				q.setOptionList(Opt_list);
			}
			questionnaire.add(q);
		}
		return questionnaire;
    }
    
    
}