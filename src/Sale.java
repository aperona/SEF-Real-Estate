
public class Sale extends Property {

	private double price;
	private boolean offerMade;
	private double percent;
	private double commission = (price / 100) * percent;
	private double offer;
	private Sale[] forSaleProperties = new Sale[100];
	
	// Constructor for the Sale Object
	public Sale(String address, String suburb, int bedrooms, int bathrooms, int carSpaces, String type, double price) {
		super(address, suburb, bedrooms, bathrooms, carSpaces, type);
		this.price = price;
		addToArray(this);
	}
	
	// Alternate constructor for Sale object when converting from property to a property for sale
	public Sale(Property p, double price) {
		super(p.getAddress(), p.getSuburb(), p.getBedrooms(), p.getBathrooms(), p.getCarSpaces(), p.getType());
		this.price = price;
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
	
	// getter for offer double
	public double getOffer() {
		return offer;
	}
	
    // setter for offer double
	public void setOffer(double offer) {
		this.offer = offer;
	}
	
	// Method to change to a property for sale; adds it to array
	public void makeForSale(Property p, double price) {
		Sale sale = new Sale(p, price);
		addToArray(sale);
	}
	
	// Private method to add sale objects to array to avoid duplicated code
	private void addToArray(Sale sale) {
		for(Sale s : forSaleProperties) {
			if(s.equals(null)) {
				s = sale;
				return;
			}
		}
		System.out.println("Did not add to array");
	}
	
	public String toString() {
		String details = "";
		details += System.out.printf("%s, %s, %d, %d, %d, %s, %f", super.getAddress(), super.getSuburb(), super.getBedrooms(), super.getBathrooms(), super.getCarSpaces(), super.getType(), price);
		return details;
	}
}