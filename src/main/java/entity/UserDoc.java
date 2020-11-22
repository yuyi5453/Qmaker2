package entity;

/**
 * UserDoc entity. @author MyEclipse Persistence Tools
 */

public class UserDoc implements java.io.Serializable {

	// Fields

	private String userId;
	private String password;

	// Constructors

	/** default constructor */
	public UserDoc() {
	}

	/** minimal constructor */
	public UserDoc(String userId) {
		this.userId = userId;
	}

	/** full constructor */
	public UserDoc(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}