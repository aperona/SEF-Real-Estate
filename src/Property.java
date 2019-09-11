
public class Property {

	private String address;
	private String suburb;
	private int bedrooms;
	private int bathrooms;
	private int carSpaces;
	private String type;
	private String propId;
	private String description;

	public Property(String address, String suburb, int bedrooms, int bathrooms, int carSpaces, String type) {
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
	
	

}
