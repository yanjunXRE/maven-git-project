package devopsproject;

public class user {
	 protected String password;
	 public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public user(String password, String email) {
		super();
		this.password = password;
		this.email = email;
	}
	protected String email;
}
