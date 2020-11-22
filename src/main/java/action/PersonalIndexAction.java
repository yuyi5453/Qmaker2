package action;

import java.util.List;



import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import service.PersonalIndexService;


public class PersonalIndexAction extends ActionSupport{
	
	PersonalIndexService personalIndexService;
    	String userId;
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
