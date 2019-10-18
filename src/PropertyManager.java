import java.util.Date;

public class PropertyManager extends Employee {

	public PropertyManager(String empId, String username, String email, String password, String name, String surname, String phNumber, boolean workType) {
		super(empId, username, email, password, name, surname, phNumber, workType);
	}
	
	public void scheduleInspect(Date date) {
		String d = String.format("%d/%d/%d", date.getDay(), date.getMonth(), date.getYear());
		System.out.println("Inspection scheduled for: " + d);
	}
	
	public void checkReport() {
		System.out.println("Report checked");
	}
	
	public void advertiseProp(Property p) {
		System.out.println("Property " + p.getPropId() + " will be advertised shortly");
	}
	
	public void organiseMaintenance() {
		System.out.println("Maintenance scheduled");
	}
	
}
