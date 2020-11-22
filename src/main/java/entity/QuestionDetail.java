package entity;

/**
 * QuestionDetail entity. @author MyEclipse Persistence Tools
 */

public class QuestionDetail implements java.io.Serializable {

	// Fields

	private QuestionDetailId id;
	private String questionContent;
	private String questionType;
	private Integer optionNum;

	// Constructors

	/** default constructor */
	public QuestionDetail() {
	}

	/** minimal constructor */
	public QuestionDetail(QuestionDetailId id) {
		this.id = id;
	}

	/** full constructor */
	public QuestionDetail(QuestionDetailId id, String questionContent, String questionType, Integer optionNum) {
		this.id = id;
		this.questionContent = questionContent;
		this.questionType = questionType;
		this.optionNum = optionNum;
	}

	// Property accessors

	public QuestionDetailId getId() {
		return this.id;
	}

	public void setId(QuestionDetailId id) {
		this.id = id;
	}

	public String getQuestionContent() {
		return this.questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public String getQuestionType() {
		return this.questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public Integer getOptionNum() {
		return this.optionNum;
	}

	public void setOptionNum(Integer optionNum) {
		this.optionNum = optionNum;
	}

}