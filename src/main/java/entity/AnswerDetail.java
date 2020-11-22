package entity;

/**
 * AnswerDetail entity. @author MyEclipse Persistence Tools
 */

public class AnswerDetail implements java.io.Serializable {

	// Fields

	private AnswerDetailId id;
	private String answer;

	// Constructors

	/** default constructor */
	public AnswerDetail() {
	}

	/** minimal constructor */
	public AnswerDetail(AnswerDetailId id) {
		this.id = id;
	}

	/** full constructor */
	public AnswerDetail(AnswerDetailId id, String answer) {
		this.id = id;
		this.answer = answer;
	}

	// Property accessors

	public AnswerDetailId getId() {
		return this.id;
	}

	public void setId(AnswerDetailId id) {
		this.id = id;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}