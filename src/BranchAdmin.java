
public class BranchAdmin extends Employee {

	public BranchAdmin(String empId, String username, String email, String password, String name, String surname, String phNumber, boolean workType) {
		super(empId, username, email, password, name, surname, phNumber, workType);
	}
	
	public void collectRent() {
		System.out.println("Rent reveived. Thank You");
	}
	
	public void scanDocument() {
		System.out.println("Document scanned");
	}
	
	public void creditAccount() {
		System.out.println("Money received and added to account");
	}
	
	public void receiveDocument() {
		System.out.println("Document Received");
	}
	
}
