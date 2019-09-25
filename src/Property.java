
public class Property {

	private String address;
	private String suburb;
	private int bedrooms;
	private int bathrooms;
	private int carSpaces;
	private String type;
	private String propId;
	private int id;
	private String description;
	private Property[] properties = new Property[100];

	public Property(String address, String suburb, int bedrooms, int bathrooms, int carSpaces, String type) {
		this.address = address;
		this.suburb = suburb;
		this.bedrooms = bedrooms;
		this.bathrooms = bathrooms;
		this.carSpaces = carSpaces;
		this.type = type;
		setPropId();
		addToArray(this);
	}
	
	private void setPropId() {
		if(propId == null) {
			propId = "00";
			id = 1;
			return;
		}
		if(id < 10) {
			propId = "0" + Integer.toString(id);
		} else
			propId = Integer.toString(id);
		id++;
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
	
	public String getDetails() {
		String details = "";
		details += String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n", "Property: " + propId, "Address: " + address, "Suburb: " + suburb, "no. of bedrooms: " + bedrooms,
				"no. of Bathrooms: " + bathrooms, "no. of Car Spaces: " + carSpaces, "Type: " + type);
		return details;
	}
	
	public String printProperties() {
		String details = "";
		for(int i = 0; i < properties.length; i++) {
			if(properties[i] == null) {
				details += properties[i].getDetails();
				return details;
			}
		}
		return details;
	}
	
	protected void addToArray(Property prop) {
		for(Property p : properties) {
			if(p == null) {
				p = prop;
				System.out.println("YO");
				System.out.println(p.getDetails());
				return;
			}
			System.out.println("YOO");
		}
		System.out.println("Did not add to array");
	}
	

}
