
public class  Customer extends Account {
	private String custID;
	private String name;
	private String surname;
	private String phNumber;
	private String type;
	private String landLord;
	private String vendor;
	private static int id;

	// Customer constructor
	public Customer(String username, String email, String password, String custID, String name, String surname, String phNumber,
			String landLord, String vendor) {
		super(username, email, password);
		this.custID = custID;
		this.type = "Customer";
		this.name = name;
		this.surname = surname;
		this.phNumber = phNumber;
		this.landLord = landLord;
		this.vendor = vendor;
		setCustID();
	}
	
	public String getcustID() {
		return custID;
	}
	

	private void setCustID() {
		if(id < 10) {
			custID = "0" + Integer.toString(id);
		} else
			custID = Integer.toString(id);
		id++;
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
		return super.getUsername() + "," + super.getEmail() + ',' + super.getPassword() + "," + this.type + "," + this.custID + ","
				+ this.name + "," + this.surname + "," + this.phNumber;

	}

}