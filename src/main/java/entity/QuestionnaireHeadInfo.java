package entity;

import java.sql.Timestamp;

/**
 * QuestionnaireHeadInfo entity. @author MyEclipse Persistence Tools
 */

public class QuestionnaireHeadInfo implements java.io.Serializable {

	// Fields

	private String questionnaireId;
	private String userId;
	private String title;
	private Integer questionNum;
	private Timestamp lastChangedTime;
	private String status;

	// Constructors

	/** default constructor */
	public QuestionnaireHeadInfo() {
	}

	/** minimal constructor */
	public QuestionnaireHeadInfo(String questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	/** full constructor */
	public QuestionnaireHeadInfo(String questionnaireId, String userId, String title, Integer questionNum,
			Timestamp lastChangedTime, String status) {
		this.questionnaireId = questionnaireId;
		this.userId = userId;
		this.title = title;
		this.questionNum = questionNum;
		this.lastChangedTime = lastChangedTime;
		this.status = status;
	}

	// Property accessors

	public String getQuestionnaireId() {
		return this.questionnaireId;
	}

	public void setQuestionnaireId(String questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getQuestionNum() {
		return this.questionNum;
	}

	public void setQuestionNum(Integer questionNum) {
		this.questionNum = questionNum;
	}

	public Timestamp getLastChangedTime() {
		return this.lastChangedTime;
	}

	public void setLastChangedTime(Timestamp lastChangedTime) {
		this.lastChangedTime = lastChangedTime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}