
public class Rental extends Property {

	private double rent;
	private Rental[] rentalProperties = new Rental[100];
	private boolean discountQualified;
	private int managementFee = 8;
	
	// Constructor for Rental Object
	public Rental(String address, String suburb, int bedrooms, int bathrooms, int carSpaces, String type, double rent) {
		super(address, suburb, bedrooms, bathrooms, carSpaces, type);
		this.rent = rent;
	}
	
	// Alternative constructor for when a Property already exists and is becoming a property for rent
	public Rental(Property p, double rent) {
		super(p.getAddress(), p.getSuburb(), p.getBedrooms(), p.getBathrooms(), p.getCarSpaces(), p.getType());
		this.rent = rent;
	}
	
	// Getter for the rent double
	public double getRent() {
		return rent;
	}
	
	// Setter for the rent double
	public void setRent(double rent) {
		this.rent = rent;
	}
	
	// toString method for the Rental Class
	public String toString() {
		String details = "";
		details += System.out.printf("%s, %s, %d, %d, %d, %s, %f", super.getAddress(), super.getSuburb(), super.getBedrooms(), super.getBathrooms(), super.getCarSpaces(), super.getType(), rent);
		return details;
	}
	
	// Called to change a property to a rental property, adds it to array
	public boolean makeRental(Property p, double rent) {
		Rental renting = new Rental(p, rent);
		for(Rental r : rentalProperties) {
			if(r.equals(null)) {
				r = renting;
				return true;
			}
		}
		return false;
	}

	// Getter for discount qualified boolean
	public boolean isDiscountQualified() {
		return discountQualified;
	}

	// Setter for discount qualified boolean
	public void setDiscountQualified(boolean discountQualified) {
		this.discountQualified = discountQualified;
	}
	
}
