package entityStruct;

public class Option {
	String  questionnaireId;
	int questionNo;
	int optionNo;
	String optionContent;
	String isStandardAnswer;
	String isUserAnswer;
	int statistic;
	public int getOptionNo() {
		return optionNo;
	}
	public void setOptionNo(int optionNo) {
		this.optionNo = optionNo;
	}
	public String getOptionContent() {
		return optionContent;
	}
	public void setOptionContent(String optionContent) {
		this.optionContent = optionContent;
	}
	public String  getQuestionnaireId() {
		return questionnaireId;
	}
	public void setQuestionnaireId(String questionnaireId) {
		this.questionnaireId = questionnaireId;
	}
	public int getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}
	public String getIsStandardAnswer() {
		return isStandardAnswer;
	}
	public void setIsStandardAnswer(String isStandardAnswer) {
		this.isStandardAnswer = isStandardAnswer;
	}
	public String getIsUserAnswer() {
		return isUserAnswer;
	}
	public void setIsUserAnswer(String isUserAnswer) {
		this.isUserAnswer = isUserAnswer;
	}
	public int getStatistic() {
		return statistic;
	}
	public void setStatistic(int statistic) {
		this.statistic = statistic;
	}
	
}
