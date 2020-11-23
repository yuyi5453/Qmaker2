package action;

import java.util.List;



import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.PersonalIndexService;

@Component
public class PersonalIndexAction extends ActionSupport{
	@Autowired
	PersonalIndexService personalIndexService;
    	String userId;

	public PersonalIndexService getPersonalIndexService() {
		return personalIndexService;
	}

	public void setPersonalIndexService(PersonalIndexService personalIndexService) {
		this.personalIndexService = personalIndexService;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List getQuestionnaireList() {
		return questionnaireList;
	}

	public void setQuestionnaireList(List questionnaireList) {
		this.questionnaireList = questionnaireList;
	}

	List questionnaireList = null;
	
	public String execute(){
		Map<String, Object> session = ActionContext.getContext().getSession();
        	userId = (String) session.get("userId");
        	session.put("questionnaireStatus","PUBLISHED");
        	questionnaireList = personalIndexService.get_Published_Questionnaire_By_UId(userId);
        	return SUCCESS;
	}
	public String exec_Get_Unpublished() {
        	Map<String, Object> session = ActionContext.getContext().getSession();
        	userId = (String) session.get("userId");
        	session.put("questionnaireStatus","UNPUBLISHED");
        	questionnaireList = personalIndexService.get_Unpublished_Questionnaire_By_UId(userId);
		return SUCCESS;
	}

}
