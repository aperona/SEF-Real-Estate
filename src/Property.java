
public class Property {

	private String address;
	private String suburb;
	private int bedrooms;
	private int bathrooms;
	private int carSpaces;
	private String type;
	private String propId;
	private static int id;
	private String description;

	public Property(String propId, String address, String suburb, int bedrooms, int bathrooms, int carSpaces, String type) {
		this.propId = propId;
		this.address = address;
		this.suburb = suburb;
		this.bedrooms = bedrooms;
		this.bathrooms = bathrooms;
		this.carSpaces = carSpaces;
		this.type = type;
		setPropId();
	}
	
	public String toString() {
		String details = "";
		details += System.out.printf("%s, %s, %d, %d, %d, %s", address, suburb, bedrooms, bathrooms, carSpaces, type);
		return details;
	}
	
	public String getDetails() {
		String details = "";
		details += String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n", "Property: " + propId, "Address: " + address, "Suburb: " + suburb, "no. of bedrooms: " + bedrooms,
				"no. of Bathrooms: " + bathrooms, "no. of Car Spaces: " + carSpaces, "Type: " + type);
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
	

	private void setPropId() {
		if(id < 10) {
			propId = "0" + Integer.toString(id);
		} else
			propId = Integer.toString(id);
		id++;
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
