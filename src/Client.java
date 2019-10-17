
public abstract class Client extends Customer {
	private String prefSuburb;
	
	public Client(String username, String email, String password, String name, String surname, String phNumber,
			String landLord, String vendor, String prefSuburb) {
		super(username, email, password, name, surname, phNumber, landLord, vendor);
		this.prefSuburb = prefSuburb;
	}

	
	public String getPrefSuburb() {
		return this.prefSuburb;
	}

	public void setPrefSuburb(String prefSuburb) {
		this.prefSuburb = prefSuburb;
		return;
	}
}
