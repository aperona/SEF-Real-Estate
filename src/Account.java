//account class, used to represent accounts
public abstract class Account {
	// account class which contains the username and password for all child classes
	private String username;
	private String email;
	private String password;

	public Account(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;

	}

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	public String getEmail() {
		return this.email;
	}

	public String toString() {
		return this.username + ',' + this.email + ',' + this.password;

	}
}
