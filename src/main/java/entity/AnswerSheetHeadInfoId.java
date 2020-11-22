package entity;

/**
 * AnswerSheetHeadInfoId entity. @author MyEclipse Persistence Tools
 */

public class AnswerSheetHeadInfoId implements java.io.Serializable {

	// Fields

	private String answerSheetId;
	private String questionnaireId;

	// Constructors

	/** default constructor */
	public AnswerSheetHeadInfoId() {
	}

	/** full constructor */
	public AnswerSheetHeadInfoId(String answerSheetId, String questionnaireId) {
		this.answerSheetId = answerSheetId;
		this.questionnaireId = questionnaireId;
	}

	// Property accessors

	public String getAnswerSheetId() {
		return this.answerSheetId;
	}

	public void setAnswerSheetId(String answerSheetId) {
		this.answerSheetId = answerSheetId;
	}

	public String getQuestionnaireId() {
		return this.questionnaireId;
	}

	public void setQuestionnaireId(String questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AnswerSheetHeadInfoId))
			return false;
		AnswerSheetHeadInfoId castOther = (AnswerSheetHeadInfoId) other;

		return ((this.getAnswerSheetId() == castOther.getAnswerSheetId())
				|| (this.getAnswerSheetId() != null && castOther.getAnswerSheetId() != null
						&& this.getAnswerSheetId().equals(castOther.getAnswerSheetId())))
				&& ((this.getQuestionnaireId() == castOther.getQuestionnaireId())
						|| (this.getQuestionnaireId() != null && castOther.getQuestionnaireId() != null
								&& this.getQuestionnaireId().equals(castOther.getQuestionnaireId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getAnswerSheetId() == null ? 0 : this.getAnswerSheetId().hashCode());
		result = 37 * result + (getQuestionnaireId() == null ? 0 : this.getQuestionnaireId().hashCode());
		return result;
	}

}