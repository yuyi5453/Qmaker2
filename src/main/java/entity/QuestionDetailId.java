package entity;

/**
 * QuestionDetailId entity. @author MyEclipse Persistence Tools
 */

public class QuestionDetailId implements java.io.Serializable {

	// Fields

	private String questionnaireId;
	private Integer questionNo;

	// Constructors

	/** default constructor */
	public QuestionDetailId() {
	}

	/** full constructor */
	public QuestionDetailId(String questionnaireId, Integer questionNo) {
		this.questionnaireId = questionnaireId;
		this.questionNo = questionNo;
	}

	// Property accessors

	public String getQuestionnaireId() {
		return this.questionnaireId;
	}

	public void setQuestionnaireId(String questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public Integer getQuestionNo() {
		return this.questionNo;
	}

	public void setQuestionNo(Integer questionNo) {
		this.questionNo = questionNo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof QuestionDetailId))
			return false;
		QuestionDetailId castOther = (QuestionDetailId) other;

		return ((this.getQuestionnaireId() == castOther.getQuestionnaireId())
				|| (this.getQuestionnaireId() != null && castOther.getQuestionnaireId() != null
						&& this.getQuestionnaireId().equals(castOther.getQuestionnaireId())))
				&& ((this.getQuestionNo() == castOther.getQuestionNo())
						|| (this.getQuestionNo() != null && castOther.getQuestionNo() != null
								&& this.getQuestionNo().equals(castOther.getQuestionNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getQuestionnaireId() == null ? 0 : this.getQuestionnaireId().hashCode());
		result = 37 * result + (getQuestionNo() == null ? 0 : this.getQuestionNo().hashCode());
		return result;
	}

}