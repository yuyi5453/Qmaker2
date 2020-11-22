package service;

import java.util.List;

public interface PersonalIndexService {
    
    public List get_Published_Questionnaire_By_UId(String userId);

    public List get_Unpublished_Questionnaire_By_UId(String UserID);

}