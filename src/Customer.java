
public class Customer extends Account {

	private String name;
	private String surname;
	private String phNumber;
	private String type;
	private String landLord;
	private String vendor;

	// Customer constructor
	public Customer(String username, String email, String password, String name, String surname, String phNumber,
			String landLord, String vendor) {
		super(username, email, password);
		this.type = "Customer";
		this.name = name;
		this.surname = surname;
		this.phNumber = phNumber;
		this.landLord = landLord;
		this.vendor = vendor;

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
	public String getLandLord() {
		return this.landLord;
	}

	public String getVendor() {
		return this.vendor;
	}

	public void setType(String type) {
		this.type = type;
		return;

	}
	public void setLandLord(String landLord) {
		this.landLord = landLord;
		return;

	}
	public void setvendor(String vendor) {
		this.vendor = vendor;
		return;

	}
	public String toString() {
		return super.getUsername() + "," + super.getEmail() + ',' + super.getPassword() + "," + this.type + ","
				+ this.name + "," + this.surname + "," + this.phNumber;

	}

}