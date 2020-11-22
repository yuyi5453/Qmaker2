package entity;

/**
 * AnswerDetailId entity. @author MyEclipse Persistence Tools
 */

public class AnswerDetailId implements java.io.Serializable {

	// Fields

	private String answerSheetId;
	private Integer questionNo;

	// Constructors

	/** default constructor */
	public AnswerDetailId() {
	}

	/** full constructor */
	public AnswerDetailId(String answerSheetId, Integer questionNo) {
		this.answerSheetId = answerSheetId;
		this.questionNo = questionNo;
	}

	// Property accessors

	public String getAnswerSheetId() {
		return this.answerSheetId;
	}

	public void setAnswerSheetId(String answerSheetId) {
		this.answerSheetId = answerSheetId;
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
		if (!(other instanceof AnswerDetailId))
			return false;
		AnswerDetailId castOther = (AnswerDetailId) other;

		return ((this.getAnswerSheetId() == castOther.getAnswerSheetId())
				|| (this.getAnswerSheetId() != null && castOther.getAnswerSheetId() != null
						&& this.getAnswerSheetId().equals(castOther.getAnswerSheetId())))
				&& ((this.getQuestionNo() == castOther.getQuestionNo())
						|| (this.getQuestionNo() != null && castOther.getQuestionNo() != null
								&& this.getQuestionNo().equals(castOther.getQuestionNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getAnswerSheetId() == null ? 0 : this.getAnswerSheetId().hashCode());
		result = 37 * result + (getQuestionNo() == null ? 0 : this.getQuestionNo().hashCode());
		return result;
	}

}