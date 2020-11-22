package entity;

/**
 * OptionDetailId entity. @author MyEclipse Persistence Tools
 */

public class OptionDetailId implements java.io.Serializable {

	// Fields

	private String questionnaireId;
	private Integer questionNo;
	private Integer optionNo;

	// Constructors

	/** default constructor */
	public OptionDetailId() {
	}

	/** full constructor */
	public OptionDetailId(String questionnaireId, Integer questionNo, Integer optionNo) {
		this.questionnaireId = questionnaireId;
		this.questionNo = questionNo;
		this.optionNo = optionNo;
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

	public Integer getOptionNo() {
		return this.optionNo;
	}

	public void setOptionNo(Integer optionNo) {
		this.optionNo = optionNo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OptionDetailId))
			return false;
		OptionDetailId castOther = (OptionDetailId) other;

		return ((this.getQuestionnaireId() == castOther.getQuestionnaireId())
				|| (this.getQuestionnaireId() != null && castOther.getQuestionnaireId() != null
						&& this.getQuestionnaireId().equals(castOther.getQuestionnaireId())))
				&& ((this.getQuestionNo() == castOther.getQuestionNo()) || (this.getQuestionNo() != null
						&& castOther.getQuestionNo() != null && this.getQuestionNo().equals(castOther.getQuestionNo())))
				&& ((this.getOptionNo() == castOther.getOptionNo()) || (this.getOptionNo() != null
						&& castOther.getOptionNo() != null && this.getOptionNo().equals(castOther.getOptionNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getQuestionnaireId() == null ? 0 : this.getQuestionnaireId().hashCode());
		result = 37 * result + (getQuestionNo() == null ? 0 : this.getQuestionNo().hashCode());
		result = 37 * result + (getOptionNo() == null ? 0 : this.getOptionNo().hashCode());
		return result;
	}

}