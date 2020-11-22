package entity;

/**
 * AnswerSheetHeadInfo entity. @author MyEclipse Persistence Tools
 */

public class AnswerSheetHeadInfo implements java.io.Serializable {

	// Fields

	private AnswerSheetHeadInfoId id;

	// Constructors

	/** default constructor */
	public AnswerSheetHeadInfo() {
	}

	/** full constructor */
	public AnswerSheetHeadInfo(AnswerSheetHeadInfoId id) {
		this.id = id;
	}

	// Property accessors

	public AnswerSheetHeadInfoId getId() {
		return this.id;
	}

	public void setId(AnswerSheetHeadInfoId id) {
		this.id = id;
	}

}