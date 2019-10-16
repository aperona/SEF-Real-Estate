
public class Property {

	private String address;
	private String suburb;
	private int bedrooms;
	private int bathrooms;
	private int carSpaces;
	private String type;
	private String propId;

	public Property(String propId, String address, String suburb, int bedrooms, int bathrooms, int carSpaces, String type) {
		this.propId = propId;
		this.address = address;
		this.suburb = suburb;
		this.bedrooms = bedrooms;
		this.bathrooms = bathrooms;
		this.carSpaces = carSpaces;
		this.type = type;
	}
	
	public String toString() {
		String details = "";
		details += System.out.printf("%s, %s, %d, %d, %d, %s", address, suburb, bedrooms, bathrooms, carSpaces, type);
		return details;
	}
	
	public String getDetails() {
		String details = "";
		details += String.format("%-20s%s\n%-20s%s\n%-20s%s\n%-20s%s\n%-20s%s\n%-20s%s\n%-20s%s\n", "Property: ", propId, "Address: ", address, "Suburb: ", suburb, "no. of bedrooms: ", bedrooms,
				"no. of Bathrooms: ", bathrooms, "no. of Car Spaces: ", carSpaces, "Type: ", type);
		return details;
	}
	public String getDetailsSave() {
		String details = propId+","+ address+","+ suburb+","+ bedrooms+","+ bathrooms+","+ carSpaces+","+type;
		
		return details;
	}
	
	public String getAddress() {
		return address;
	}

	public String getSuburb() {
		return suburb;
	}

	public int getBedrooms() {
		return bedrooms;
	}

	public int getBathrooms() {
		return bathrooms;
	}

	public int getCarSpaces() {
		return carSpaces;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getPropId() {
		return propId;
	}
	
	public boolean makeOffer(double amount) {
		System.out.println("Offer made on a property that is not for sale. This should not happen");
		return false;
	}
	
	public void sell(double amount) {
		
	}
	
	public void rent(double amount, int contract) {
		
	}
	
	public boolean makeApplication(double amount, int contract) {
		System.out.println("Offer made on a property that is not for lease. This should not happen");
		return false;
	}
	/*
	 * Code removed - Added to RealEstateManager.
	public void printProperties() {
		String details = "";
		for(Property p : properties) {
			System.out.println(p.getDetails());
		}
	}
	
	public void removeFromArray(Property p) {
		properties.remove(properties.indexOf(p));
	}
	
	public void addToArray(Property p) {
		properties.add(p);
	}
	
	// Takes a property and turns it into a Rental Property
	public void changePropertyTypeToRental(Property prop, double rent) {
		for(Property p : properties) {
			if(p.getPropId().equals(prop.getPropId())) {
				p = null;
			}
		}
		Rental r = new Rental(prop, rent);
	}
	
	// Takes a property and turns it into a Sale Property
	public void changePropertyTypeToSale(Property prop, double price) {
		for(Property p : properties) {
			if(p.getPropId().equals(prop.getPropId())) {
				p = null;
			}
		}
		Sale s = new Sale(prop, price);
	}
	*/

}
