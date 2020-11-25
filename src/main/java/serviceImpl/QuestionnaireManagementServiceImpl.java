package serviceImpl;

import java.sql.Timestamp;
import java.util.*;

import dao.OptionDetailDao;
import dao.QuestionDetailDao;
import dao.QuestionnaireHeadInfoDao;
import entity.OptionDetail;
import entity.QuestionDetail;
import entity.QuestionnaireHeadInfo;
import entityStruct.Option;
import entityStruct.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import service.QuestionnaireManagementService;

@Component("questionnaireManagementService")
public class QuestionnaireManagementServiceImpl implements QuestionnaireManagementService {
	@Autowired
	private QuestionnaireHeadInfoDao questionnaireHeadInfoDao;
	@Autowired
	private QuestionDetailDao questionDetailDao;
	@Autowired
	private OptionDetailDao optionDetailDao;

	@Override
	public List<Question> get_Questionnaire_By_QId(String questionnaireId) {

		List<QuestionDetail> question_detail_list = questionDetailDao.get_question_detail(questionnaireId);

		List<Question> questionnaire = new ArrayList<>();


		Iterator<QuestionDetail> iterator = question_detail_list.iterator();
		while(iterator.hasNext()){

			QuestionDetail questionDetail = iterator.next();

			int questionNo = questionDetail.getId().getQuestionNo();

			List<OptionDetail> optionDetailByQIdQNo = optionDetailDao.get_Option_Detail_By_QId_QNo(questionnaireId, Integer.toString(questionNo));

			Question question = new Question();

			question.setQuestionnaireId(questionnaireId);
			question.setQuestionNo(questionNo);
			question.setQuestionContent(questionDetail.getQuestionContent().trim());
			question.setQuestionType(questionDetail.getQuestionType().trim());
			question.setOptionNum(optionDetailByQIdQNo.size());

			List<Option> options = new ArrayList<>();
			Iterator<OptionDetail> optionIterator = optionDetailByQIdQNo.iterator();
			while(optionIterator.hasNext()){
				OptionDetail optionDetail = optionIterator.next();
				Option option = new Option();
				option.setQuestionnaireId(questionnaireId);
				option.setQuestionNo(questionNo);
				option.setOptionNo(optionDetail.getId().getOptionNo());
				option.setOptionContent(optionDetail.getOptionContent());
				options.add(option);
			}
			question.setOptionList(options);
			questionnaire.add(question);
		}

		return questionnaire;
	}

	@Override
	public List get_QuestionnaireHeadInfo_By_QId(String questionnaireId) {
		return questionnaireHeadInfoDao.get_Questionnaire_By_QId(questionnaireId);
	}

	@Override
	public String insert_New_Questionnaire(String title, int questionNum, String userId,List<Question> questions) {

		String questionnaireId = UUID.randomUUID().toString().replace("-","");

		Timestamp curTime = new Timestamp(new Date().getTime());
		questionnaireHeadInfoDao.insert_New_Quesitonnaire(questionnaireId,userId,title,questionNum,curTime,"UNPUBLISHED");
		int quesNo = 0;
		for(Question question:questions){
			questionDetailDao.insert_question_detail(questionnaireId,quesNo++,question.getQuestionContent(),question.getQuestionType(),question.getOptionNum());
			List<Option> optionList = question.getOptionList();
			int opNo=0;
			for (Option option:optionList){
				optionDetailDao.insert_Option_Detail(questionnaireId,quesNo,opNo++,option.getOptionContent());
			}
		}
		return questionnaireId;
	}
	

	@Override
	public void delete_Questionnaire_By_QId(String questionnaireId) {

		questionnaireHeadInfoDao.delete_QuestionnaireHeadInfo((QuestionnaireHeadInfo) questionnaireHeadInfoDao.get_Questionnaire_By_QId(questionnaireId).get(0));

		questionDetailDao.delete_Qustion_Detail_By_QId(questionnaireId);

		optionDetailDao.delete_Option_Detail((OptionDetail) optionDetailDao.get_Option_Detail_By_QId(questionnaireId));
	}


	@Override
	public void update_QuestionnaireHeadInfo_By_QId(String questionnaireId, String title, int questionNum) {
		questionnaireHeadInfoDao.update_Title(questionnaireId,title);
		questionnaireHeadInfoDao.update_questionNum(questionnaireId,questionNum);
	}

	@Override
	public void publish_Questionnaire(String questionnaireId) {
		questionnaireHeadInfoDao.update_Published(questionnaireId,"PUBLICSHED");
	}

	@Override
	public void update_Questionnaire_By_QId(String questionnaireId,String title, int questionNum, String userId,List<Question> questions) {
		if(questionnaireHeadInfoDao.get_Questionnaire_By_QId(questionnaireId).size()!=0)
			delete_Questionnaire_By_QId(questionnaireId);
		insert_New_Questionnaire(title,questionNum,userId,questions);
	}
}
