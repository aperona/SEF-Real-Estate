import java.util.ArrayList;
import java.util.List;

public class Rental extends Property {

	private double weeklyRental;
	private boolean discountQualified;
	private int managementFee = 8;
	private int contractDuration;
	private List<Application> applications = new ArrayList<>();
	
	// Constructor for Rental Object
	public Rental(String propId, String address, String suburb, int bedrooms, int bathrooms, int carSpaces, String type, double rent) {
		super(propId, address, suburb, bedrooms, bathrooms, carSpaces, type);
		this.weeklyRental = rent;
	}
	
	// Alternative constructor for when a Property already exists and is becoming a property for rent
	public Rental(Property p, double rent) {
		super(p.getPropId(), p.getAddress(), p.getSuburb(), p.getBedrooms(), p.getBathrooms(), p.getCarSpaces(), p.getType());
		this.weeklyRental = rent;
	}
	
	@Override
	public boolean makeApplication(double amount, int contract) {
		Application a = new Application(this, amount, contract);
		applications.add(a);
		return true;
	}
	
	@Override
	public void rent(double rent, int contract) {
		this.weeklyRental = rent;
		this.contractDuration = contract;
	}
	
	// Getter for the rent double
	public double getRent() {
		return weeklyRental;
	}
	
	// Setter for the rent double
	public void setRent(double rent) {
		this.weeklyRental = rent;
	}
	
	public void increaseAmount(double add) {
		weeklyRental += add;
	}
	
	// toString method for the Rental Class
	public String toString() {
		String details = "";
		details += System.out.printf("%s, %s, %d, %d, %d, %s, %f", super.getAddress(), super.getSuburb(), super.getBedrooms(), super.getBathrooms(), super.getCarSpaces(), super.getType(), weeklyRental);
		return details;
	}

	// Getter for discount qualified boolean
	public boolean isDiscountQualified() {
		return discountQualified;
	}

	// Setter for discount qualified boolean
	public void setDiscountQualified(boolean discountQualified) {
		this.discountQualified = discountQualified;
	}
	
	public String getDetails() {
		String details = super.getDetails();
		details += String.format("%-20s%s\n", "Rent Cost: ", weeklyRental + "\n");
		return details;
	}
	/* Code removed for change of arrays to RealEstateManager
	public String printRentals() {
		String details = "";
		for(Rental r : rentalProperties) {
			if(r != null) {
				details += r.getDetails();
			}
		}
		return details;
	}
	
	 Called to change a property to a rental property, adds it to array
		public void makeRental(Property p, double rent) {
			Rental renting = new Rental(p, rent);
			rentalProperties.add(renting);
		}
	 */
}
