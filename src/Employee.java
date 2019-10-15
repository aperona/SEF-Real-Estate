
public class Employee extends Account {

	private String name;
	private String surname;
	private String phNumber;
	private String type;
	// if workType is true, then employee is full time; false = part-time
	private boolean workType;
	private String empId;
	
	// Employee constructor currently identical to customer more functionality will
	// be added
	public Employee(String empId, String username, String email, String password, String name, String surname, String phNumber, boolean workType) {
		super(username, email, password);
		this.empId = empId;
		this.type = "Employee";
		this.name = name;
		this.surname = surname;
		this.phNumber = phNumber;
		this.workType = workType;
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
	
	public boolean getWorkType() {
		return workType;
	}
	
	public void setWorkType(boolean enter) {
		this.workType = enter;
	}
	
	public String getEmpId() {
		return empId;
	}

	public String toString() {
		return super.getUsername() + "," + super.getEmail() + ',' + super.getPassword() + "," + this.type + ","
				+ this.name + "," + this.surname + "," + this.phNumber;

	}

}