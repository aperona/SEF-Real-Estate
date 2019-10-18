
public class SalesConsultant extends Employee {

	public SalesConsultant(String empId, String username, String email, String password, String name, String surname, String phNumber, boolean workType) {
		super(empId, username, email, password, name, surname, phNumber, workType);
	}
	
	public void advertiseProp(Property p) {
		System.out.println("Property " + p.getPropId() + " will be advertised shortly");
	}
	
	public void organiseDoc() {
		System.out.println("Document Prepared");
	}
	
	public void facilitateNegotiations() {
		System.out.println("Negotiations underway");
	}
	
}
