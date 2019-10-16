import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sale extends Property {

	private double price;
	private boolean offerMade;
	private double percent;
	private double commission = (price / 100) * percent;
	private boolean section32;
	private boolean available;
	private List<Application> applications = new ArrayList<>();
	
	// Constructor for the Sale Object
	public Sale(String propId, String address, String suburb, int bedrooms, int bathrooms, int carSpaces, String type, double price) {
		super(propId, address, suburb, bedrooms, bathrooms, carSpaces, type);
		this.price = price;
	}
	
	// Alternate constructor for Sale object when converting from property to a property for sale
	public Sale(Property p, double price) {
		super(p.getPropId(), p.getAddress(), p.getSuburb(), p.getBedrooms(), p.getBathrooms(), p.getCarSpaces(), p.getType());
		this.price = price;
	}
	
	@Override
	public boolean makeOffer(double amount) {
		if(amount >= price) {
			offerMade = true;
			Application a = new Application(this, amount);
			applications.add(a);
			System.out.println("Your offer has been posted");
			return true;
		}else {
			System.out.println("Offer must be greater or equal to minimum asking price");
			return false;
		}
	}
	public String getDetailsSave() {
		String details = super.getPropId()+","+ super.getAddress()+","+ super.getSuburb()+","+ super.getBedrooms()+","+ super.getBathrooms()+","+ super.getCarSpaces()+","+super.getType()+","+price;
		
		return details;
	}
	@Override
	public void sell(double price) {
		this.available = false;
	}
	
	// getter for price double
	public double getPrice() {
		return price;
	}
	
	// getter for offerMade boolean
	public boolean isOfferMade() {
		return offerMade;
	}
	
	// getter for commission double
	public double getCommission() {
		return commission;
	}
	
	// setter for commission double, must be between and including 2 and 5%
	public boolean setCommissionPercent(double percent) {
		if(percent < 2 || percent > 5) {
			return false;
		} else {
			this.percent = percent;
			return true;
		}
	}
	
	// getter for section32 boolean
		public boolean isSection32() {
			return section32;
		}

	// setter for section 32 boolean
	public void setSection32(boolean section32) {
		this.section32 = section32;
	}
	
	// toString method to display the details for the Sale Object
	public String toString() {
		String details = "";
		details += System.out.printf("%s, %s, %d, %d, %d, %s, %f", super.getAddress(), super.getSuburb(), super.getBedrooms(), super.getBathrooms(), super.getCarSpaces(), super.getType(), price);
		return details;
	}
	
	public String getDetails() {
		String details = super.getDetails();
		details += String.format("%-20s%s\n", "Listed Price: ", price + "\n");
		return details;
	}
	/* Code removed as arrays added to RealEstateManager
	 Method to change to a property for sale; adds it to array
				public void makeForSale(Property p, double price) {
					Sale sale = new Sale(p, price);
					saleProperties.add(sale);
				}
	 */
}
