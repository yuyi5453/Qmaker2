package dao;

import java.util.List;

import entity.OptionDetail;

public interface OptionDetailDao {

	public List get_Option_Detail_By_QId_QNo(String questionnaireId, String questionNo);
	
	public List get_Option_Detail_By_QId(String questionnaireId);
	
	public void insert_Option_Detail(String questionnaireId, int questionNo, int optionNo, String optionContent);
	
	public void delete_Option_Detail_By_QId_QNo_ONo(String questionnaireId, int questionNo, int optionNo);
	
	public void delete_Option_Detail(OptionDetail optionDetail);
	
	
}
