
public class Customer extends Account {

	private String name;
	private String surname;
	private String phNumber;
	private String type;

	// Customer constructor
	public Customer(String username, String email, String password, String name, String surname, String phNumber) {
		super(username, email, password);
		this.type = "Customer";
		this.name = name;
		this.surname = surname;
		this.phNumber = phNumber;

	}

	public String getName() {
		return this.name;
	}

	public String getSurname() {
		return this.surname;
	}

	public String getPhNumber() {
		return this.phNumber;
	}

	public void setType(String type) {
		this.type = type;
		return;

	}

	public String toString() {
		return super.getUsername() + "," + super.getEmail() + ',' + super.getPassword() + "," + this.type + ","
				+ this.name + "," + this.surname + "," + this.phNumber;

	}

}