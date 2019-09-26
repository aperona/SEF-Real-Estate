import java.util.ArrayList;

public class Rental extends Property {

	private double weeklyRental;
//	private Rental[] rentalProperties = new Rental[100];
	private static ArrayList<Rental> rentalProperties = new ArrayList<Rental>();
	private boolean discountQualified;
	private int managementFee = 8;
	private String contractDuration;
	
	// Constructor for Rental Object
	public Rental(String address, String suburb, int bedrooms, int bathrooms, int carSpaces, String type, double rent) {
		super(address, suburb, bedrooms, bathrooms, carSpaces, type);
		this.weeklyRental = rent;
		rentalProperties.add(this);
	}
	
	// Alternative constructor for when a Property already exists and is becoming a property for rent
	public Rental(Property p, double rent) {
		super(p.getAddress(), p.getSuburb(), p.getBedrooms(), p.getBathrooms(), p.getCarSpaces(), p.getType());
		this.weeklyRental = rent;
		rentalProperties.add(this);
		p.removeFromArray(p);
		p.addToArray(this);
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
	
	// Called to change a property to a rental property, adds it to array
	public void makeRental(Property p, double rent) {
		Rental renting = new Rental(p, rent);
		rentalProperties.add(renting);
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
		details += String.format("%s\n", "Rent Cost: " + weeklyRental);
		return details;
	}
	
	public String printRentals() {
		String details = "";
		for(Rental r : rentalProperties) {
			if(r != null) {
				details += r.getDetails();
			}
		}
		return details;
	}
	
}
