
public class Employee extends Account {

	private String name;
	private String surname;
	private String phNumber;
	private String type;

	// Employee constructor currently identical to customer more functionality will
	// be added
	public Employee(String username, String email, String password, String name, String surname, String phNumber)
			throws Exception {
		super(username, email, password);
		this.type = "Employee";
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