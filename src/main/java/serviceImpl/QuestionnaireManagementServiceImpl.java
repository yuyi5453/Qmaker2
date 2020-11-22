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
	//获取问卷内容
	@Override
	public List<Question> get_Questionnaire_By_QId(String questionnaireId) {
		//根据问卷ID查询问卷中所有问题
		List<QuestionDetail> question_detail_list = questionDetailDao.get_question_detail(questionnaireId);
		//QUestion List 返回值
		List<Question> questionnaire = new ArrayList<>();

		//迭代器   迭代所有的QuestionDetail
		Iterator<QuestionDetail> iterator = question_detail_list.iterator();
		while(iterator.hasNext()){
			//具体一个question
			QuestionDetail questionDetail = iterator.next();
			//问题编号
			int questionNo = questionDetail.getId().getQuestionNo();
			//根据问卷ID  和  问题标号  获取所有选项
			List<OptionDetail> optionDetailByQIdQNo = optionDetailDao.get_Option_Detail_By_QId_QNo(questionnaireId, Integer.toString(questionNo));

			Question question = new Question();//实例化QUestion
			//对question进行赋值操作
			question.setQuestionnaireId(questionnaireId);//问卷ID
			question.setQuestionNo(questionNo);//问题编号
			question.setQuestionContent(questionDetail.getQuestionContent().trim());//问题内容
			question.setQuestionType(questionDetail.getQuestionType().trim());//问题类型
			question.setOptionNum(optionDetailByQIdQNo.size());//选项个数
			//设置问题选项
			List<Option> options = new ArrayList<>();	//选项集合
			Iterator<OptionDetail> optionIterator = optionDetailByQIdQNo.iterator();
			while(optionIterator.hasNext()){
				OptionDetail optionDetail = optionIterator.next();
				Option option = new Option();//实例化Option
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

	//新建问卷
	@Override
	public String insert_New_Questionnaire(String title, int questionNum, String userId,List<Question> questions) {
		//随机生成问卷ID
		String questionnaireId = UUID.randomUUID().toString();
		//当前时间戳
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
	
	//删除问卷
	@Override
	public void delete_Questionnaire_By_QId(String questionnaireId) {
		//删除问卷头
		questionnaireHeadInfoDao.delete_QuestionnaireHeadInfo((QuestionnaireHeadInfo) questionnaireHeadInfoDao.get_Questionnaire_By_QId(questionnaireId).get(0));
		//删除问题
		questionDetailDao.delete_Qustion_Detail_By_QId(questionnaireId);
		//删除选项
		optionDetailDao.delete_Option_Detail((OptionDetail) optionDetailDao.get_Option_Detail_By_QId(questionnaireId));
	}

	//更新问卷头信息
	@Override
	public void update_QuestionnaireHeadInfo_By_QId(String questionnaireId, String title, int questionNum) {
		questionnaireHeadInfoDao.update_Title(questionnaireId,title);
		questionnaireHeadInfoDao.update_questionNum(questionnaireId,questionNum);
	}

	@Override
	public void publish_Questionnaire(String questionnaireId) {
		questionnaireHeadInfoDao.update_Published(questionnaireId,"PUBLICSHED");
	}

	//更新问卷内容
	//1.删除问卷
	//2.重新添加问卷
	@Override
	public void update_Questionnaire_By_QId(String questionnaireId,String title, int questionNum, String userId,List<Question> questions) {
		if(questionnaireHeadInfoDao.get_Questionnaire_By_QId(questionnaireId).size()!=0)
			delete_Questionnaire_By_QId(questionnaireId);
		//发布问卷
		insert_New_Questionnaire(title,questionNum,userId,questions);
	}
}
