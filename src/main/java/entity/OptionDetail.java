package entity;

/**
 * OptionDetail entity. @author MyEclipse Persistence Tools
 */

public class OptionDetail implements java.io.Serializable {

	// Fields

	private OptionDetailId id;
	private String optionContent;

	// Constructors

	/** default constructor */
	public OptionDetail() {
	}

	/** minimal constructor */
	public OptionDetail(OptionDetailId id) {
		this.id = id;
	}

	/** full constructor */
	public OptionDetail(OptionDetailId id, String optionContent) {
		this.id = id;
		this.optionContent = optionContent;
	}

	// Property accessors

	public OptionDetailId getId() {
		return this.id;
	}

	public void setId(OptionDetailId id) {
		this.id = id;
	}

	public String getOptionContent() {
		return this.optionContent;
	}

	public void setOptionContent(String optionContent) {
		this.optionContent = optionContent;
	}

}