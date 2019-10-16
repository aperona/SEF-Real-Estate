import java.util.*;
import java.io.*;

public class RealEstateManager {
	private int maxAccounts;
	private int maxProperties;
	private Account[] accountList;
	private List<Property> propertyList = new ArrayList<>();
	private List<Employee> employeeList = new ArrayList<>();
	private int accountNum;
	private int propertyNum;
	private int id;
	int accessAccount;// position of the current logged in account on array

	public RealEstateManager(int maxAccounts, int maxProperties) {
		this.maxAccounts = maxAccounts;
		this.maxProperties = maxProperties;
		this.accountList = new Account[this.maxAccounts];
		this.accountNum = 0;
		this.propertyNum = 0;
		this.accessAccount = 0;
		loadAccountData("accountData.csv");
		startLogin();
		saveAccountData("accountData.csv");
		return;
	}

	private void loadAccountData(String file) {
		try {
			BufferedReader load = new BufferedReader(new FileReader(file));
			String input = "";
			input = load.readLine();
			while (input != null) {
				String[] fields = input.split(",");

				// reads the data to find which person the data belongs to field[2] contains the
				// name of the subclass
				if (fields[2].equals("Customer")) {
					addCustomer(fields[0], fields[1], fields[2], fields[4], fields[5], fields[6], fields[7], fields[8]);
					((Customer) this.accountList[this.accountNum - 1]).setType(fields[3]);

				}
				// can be implemented later
				// if (fields[2].equals("Employee")) {
				// addEmployee(fields[0], fields[1], fields[2], fields[4], fields[5], fields[6],
				// fields[7]);
				//
				// ((Employee) this.personList[this.personNum - 1]).setType(fields[3]);
				//
				//
				// }
				// if (fields[2].equals("Admin")) {
				//
				// addAdmin(fields[0], fields[1]);
				//
				// }
				input = load.readLine();
			}

			load.close();
		}
		// if there is no person data available the program assumes that it is being ran
		// for the first time and creates a admin account
		catch (Exception e) {
			System.out.println("Error! " + e.getMessage() + "\n No account data\nCreating Admin Account");
			// createAdminPerson();
		}
		return;
	}

	private void saveAccountData(String file) {

		try {
			BufferedWriter save = new BufferedWriter(new FileWriter(file));
			int i = 0;
			while (i < this.accountNum) {
				save.write(this.accountList[i] + "\n");
				i++;
			}
			save.close();
		} catch (IOException e) {
			System.out.println("Error!" + e.getMessage() + "\nWas unable to save to file");
		}
		return;
	}

	private void startLogin() {
		Scanner kb = new Scanner(System.in);
////		TODO: Remove this
		addCustomer("a", "a", "a", "a", "a", "a", "a", "a");
		addSale("1 a lane", "Melbourne", 0, 0, 0, "House", 600000);
		addSale("2 lo street", "Melbourne", 0, 0, 0, "House", 750000);
		addSale("3 hi street", "Fitzroy", 1, 1, 1, "Flat", 900000);
		addSale("4 co street", "Melbourne", 2, 2, 2, "Unit", 100000);
		addSale("15 dave road", "Melbourne", 3, 3, 3, "TownHouse", 200000);
		addSale("6 ree road", "North Melbourne", 0, 0, 0, "Studio", 400000);
		addRental("1000 koi place", "Richmond", 1, 1, 1, "Unit", 600);
		addRental("11 bat street", "Batman", 1, 1, 1, "House", 500);
		addRental("15 two grove", "Richmond", 1, 1, 1, "Flat", 400);
		addRental("2 a road", "Richmond", 1, 1, 1, "TownHouse", 300);
		addRental("20 joe Lane", "Hawksburn", 1, 2, 0, "Studio", 200);
		addRental("60 the Road", "Brunswick", 1, 1, 1, "Unit", 100);
		addRental("16 super lane", "Richmond", 1, 1, 1, "Unit", 700);
		addRental("88 pie lane", "Shepparton", 1, 1, 1, "Unit", 800);
		addRental("105 street street", "Frankston", 1, 1, 1, "Unit", 250);
		addRental("500 nepean highway", "Richmond", 1, 1, 1, "Unit", 450);
		addRental("17 err place", "Richmond", 1, 1, 1, "Unit", 600);
		String menu = "Login\nPlease Make a Selection:\n1. Login\n2. Create Account\nTo locate account details \nplease talk to one of our staff";
		System.out.println(menu);
		int option = kb.nextInt();
		// as long as a user doesn't cancel it the menu will appear

		while (option != 0) {
			if (option == 1) {

				checkLogin();

			} else if (option == 2) {
				System.out.println("create a customer account");
				createCustomer();

			} else {
				System.out.println("Invalid Entry");// if the user enters anything other than 1-4

			}
			System.out.println(menu);
			option = kb.nextInt();
		}

	}

	void checkLogin() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter Your Username:");
		String username = kb.nextLine();
		System.out.println("Enter Your Password:");
		String password = kb.nextLine();
		int i = 0;
		while (i < this.accountNum) {
			if ((this.accountList[i]).getUsername().equals(username)
					&& (this.accountList[i]).getPassword().equals(password)) {

				System.out.println("Success!");

				if ((this.accountList[i]) instanceof Customer) {
					// accessLevel = 0;
					accessAccount = i;
					openMenu();

				}
				if ((this.accountList[i]) instanceof Employee) {
					// accessLevel = 1;
					accessAccount = i;
					openEmployeeMenu();
				}

			}

			i++;
		}
		return;

	}

	private void openEmployeeMenu() {
		Scanner kb = new Scanner(System.in);
		String menu = "Employee Menu\nPlease Make a Selection:\n1. Confirm Listings\nType 0 to log out";
		System.out.println(menu);
		int option = kb.nextInt();
		// as long as a user doesn't cancel it the menu will appear

		while (option != 0) {
			if (option == 1) {
				accountManager();

			} else if (option == 2) {

			} else {
				System.out.println("Invalid Entry");// if the user enters anything other than 1-4

			}
			System.out.println(menu);
			option = kb.nextInt();
		}

	}

	private void openMenu() {
		Scanner kb = new Scanner(System.in);
		String menu = "Main Menu\nPlease Make a Selection:\n1. Browse Properties \n2. List Properties \n3. Account Management \n4. Register Property \nType 0 to log out";
		System.out.println(menu);
		int option = kb.nextInt();
		// as long as a user doesn't cancel it the menu will appear

		while (option != 0) {
			if (option == 1) {
				browseProperties();
			} else if (option == 2) {
				System.out.println(listProperties());
			}else if (option == 3) {
				accountManager();
			} else if (option == 4) {
				makeProperty();
			} else {
				System.out.println("Invalid Entry");// if the user enters anything other than 1-4

			}
			System.out.println(menu);
			option = kb.nextInt();
		}

	}

	private void accountManager() {
		Scanner kb = new Scanner(System.in);
		String menu = "Account Management\nPlease Make a Selection:\n1. Apply to be a vendor\nApply to be a landlord\nType 0 to log out";
		System.out.println(menu);
		int option = kb.nextInt();
		// as long as a user doesn't cancel it the menu will appear

		while (option != 0) {
			if (option == 1) {

			} else if (option == 2) {

			} else {
				System.out.println("Invalid Entry");// if the user enters anything other than 1-4

			}
			System.out.println(menu);
			option = kb.nextInt();
		}
	}

	private void createCustomer() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter a username");
		String username = kb.nextLine();
		System.out.println("Enter a email");
		String email = kb.nextLine();
		System.out.println("Enter a password");
		String password = kb.nextLine();
		System.out.println("Enter your first name");
		String name = kb.nextLine();
		System.out.println("Enter your surname");
		String surname = kb.nextLine();
		System.out.println("Enter your phone number");
		String phNumber = kb.nextLine();
		System.out.println("Are you a landlord y/n");
		String option = kb.nextLine();
		String landLord = "false";
		if (option.matches("y")) {
			landLord = "true";
		}
		System.out.println("Are you a vendor y/n");
		option = kb.nextLine();
		String vendor = "false";
		if (option.matches("y")) {
			vendor = "true";
		}
		addCustomer(username, email, password, name, surname, phNumber, landLord, vendor);
		return;

	}

	private void createEmployee() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter a username");
		String username = kb.nextLine();
		System.out.println("Enter a email");
		String email = kb.nextLine();
		System.out.println("Enter a password");
		String password = kb.nextLine();
		System.out.println("Enter your first name");
		String name = kb.nextLine();
		System.out.println("Enter your surname");
		String surname = kb.nextLine();
		System.out.println("Enter your phone number");
		String phNumber = kb.nextLine();
		System.out.println("Will you be: \n1. Part-Time \n2. Full-Time");
		int empType = kb.nextInt();
		boolean workType = true;
		if(empType == 1) {
			workType = false;
		}
		System.out.println("Which position are you working in? - \n1. Branch Admin \n2. Property Manager \n3. Sales Consultant");
		int position = kb.nextInt();
		if(position == 1) {
			addBranchAdmin(username, email, password, name, surname, phNumber, workType);
		}else if(position == 2) { 
			addPropertyManager(username, email, password, name, surname, phNumber, workType);
		}else if(position == 3) {
			addSalesConsultant(username, email, password, name, surname, phNumber, workType);
		}
		return;
	}
	
	private void addBranchAdmin(String username, String email, String password, String name, String surname, String phNumber, boolean workType) {
		String empId = setEmpId();
		Employee e = new BranchAdmin(empId, username, email, password, name, surname, phNumber, workType);
		employeeList.add(e);
		System.out.println("Branch Administrator created");
	}
	
	private void addPropertyManager(String username, String email, String password, String name, String surname, String phNumber, boolean workType) {
		String empId = setEmpId();
		Employee e = new PropertyManager(empId, username, email, password, name, surname, phNumber, workType);
		employeeList.add(e);
		System.out.println("Property Manager created");
	}
	
	private void addSalesConsultant(String username, String email, String password, String name, String surname, String phNumber, boolean workType) {
		String empId = setEmpId();
		Employee e = new SalesConsultant(empId, username, email, password, name, surname, phNumber, workType);
		employeeList.add(e);
		System.out.println("Sales Consultant created");
	}
	
	private String setEmpId() {
		String empId;
		empId = String.format("%1$01d", id);
		id++;
		return empId;
	}
	
	private void addCustomer(String username, String email, String password, String name, String surname,
			String phNumber, String landLord, String vendor) {
		this.accountList[this.accountNum] = new Customer(username, email, password, name, surname, phNumber, landLord,
				vendor);
		this.accountNum += 1;

		return;

	}
	
	private void makeProperty() {
		Scanner sc = new Scanner(System.in);
		String propType;
		double price;
		System.out.println("What type of property is this - house, unit, flat, townhouse or studio");
		String type = sc.nextLine();
		System.out.println("What is the address of your " + type);
		String address = sc.nextLine();
		System.out.println("What is the suburb of your " + type);
		String suburb = sc.nextLine();
		System.out.println("How many bedrooms does your " + type + " have?");
		int bedrooms = sc.nextInt();
		System.out.println("How many bathrooms does your " + type + " have?");
		int bathrooms = sc.nextInt();
		System.out.println("How many car spaces does your " + type + " have?");
		int carSpaces = sc.nextInt();
		System.out.println("Would you like to make a property to sell, or to lease?\n1. Sell: \n2. Lease:");
		if(sc.nextInt() == 1) {
			propType = "Sale";
			System.out.println("You selected a Sale property\nWhat is the minimum you would like to list this property for?");
			price = sc.nextDouble();
		}else {
			propType = "Rental";
			System.out.println("You selected a Rental property\nHow much would you like to charge for rent per week?");
			price = sc.nextDouble();
		}
		int choice = 0;
		while(choice != 1 || choice != 2) {
			System.out.println("Confirm the adding of your property: \nType 1 for yes:\nType 2 for no:");
			choice = sc.nextInt();
			if(choice == 1) {
				if(propType.equalsIgnoreCase("sale")) {
					addSale(address, suburb, bedrooms, bathrooms, carSpaces, type, price);
				}
				if(propType.equalsIgnoreCase("rental")) {
					addRental(address, suburb, bedrooms, bathrooms, carSpaces, type, price);
				}
				return;
			}else if(choice == 2){
				System.out.println("*********************************************\nProperty Not Created - Returning to Main Menu\n*********************************************");
				return;
			}else {
				System.out.println("Re-enter your choice");
			}
		}
		
	}

	private void addProperty(String address, String suburb, int bedrooms, int bathrooms, int carSpaces, String type) {
		String propId = setPropId();
		Property p = new Property(propId, address, suburb, bedrooms, bathrooms, carSpaces, type);
		propertyList.add(p);
		System.out.println("Property Created");
	}

	private void addRental(String address, String suburb, int bedrooms, int bathrooms, int carSpaces, String type,
			double rent) {
		String propId;
		propId = setPropId();
		Property p = new Rental(propId, address, suburb, bedrooms, bathrooms, carSpaces, type, rent);
		propertyList.add(p);
		System.out.println("Rental Property Created");
	}

	private void addSale(String address, String suburb, int bedrooms, int bathrooms, int carSpaces, String type,
			double price) {
		String propId;
		propId = setPropId();
		Property p = new Sale(propId, address, suburb, bedrooms, bathrooms, carSpaces, type, price);
		propertyList.add(p);
		System.out.println("Sale Property Created");
	}

	private String setPropId() {
		String propId;
		propId = String.format("%1$01d", propertyNum);
		propertyNum++;
		return propId;
	}

	private String listProperties() {
		String details = "";
		for (Property p : propertyList) {
			details += p.getDetails();
			details += "\n";
		}
		return details;
	}

	private void browseProperties() {
		Scanner kb = new Scanner(System.in);
		String menu = "Browse Properties\nPlease Make a Selection:\n1.Looking to Rent \n2.Looking to Buy \nType 0 to return to main menu.";
		System.out.println(menu);
		int option = kb.nextInt();
		// as long as a user doesn't cancel it the menu will appear

		while (option != 0) {
			if (option == 1) {
				lookRent();

			} else if (option == 2) {
				lookSale();

			} else if (option == 3) {

			} else if (option == 4) {

			} else {
				System.out.println("Invalid Entry");// if the user enters anything other than 1-4

			}
			System.out.println(menu);
			option = kb.nextInt();
		}
	}

	private void lookRent() {
		Scanner kb = new Scanner(System.in);
		String menu = "Rental Lookup\nPlease Make a Selection:\n1.List All Rentals \n2. Search Rentals by suburb \n3. Search Rentals by weekly rent \nType 0 to return to Property Lookup.";
		System.out.println(menu);
		int option = kb.nextInt();
		// as long as a user doesn't cancel it the menu will appear

		while (option != 0) {
			if (option == 1) {
				listRentals();

			} else if (option == 2) {
				System.out.println("Which suburb would you like to search for?");
				String suburb = kb.next();
				listRentals(suburb);

			} else if (option == 3) {
				System.out.println("Would you like to search by minimum or maximum? \n1. Minimum \n2. Maximum \n");
				int search = kb.nextInt();
				System.out.println("Enter the rent");
				double amount = kb.nextDouble();
				listRentals(amount, search);
				
			} else if (option == 4) {

			} else {
				System.out.println("Invalid Entry");// if the user enters anything other than 1-4

			}
			System.out.println(menu);
			option = kb.nextInt();
		}
	}
	
	private void lookSale() {
		Scanner kb = new Scanner(System.in);
		String menu = "For Sale Lookup\nPlease Make a Selection:\n1.List All For Sale Properties \n2. Search Sales by suburb \n3. Search Sales by price\nType 0 to return to Property Lookup.";
		System.out.println(menu);
		int option = kb.nextInt();
		// as long as a user doesn't cancel it the menu will appear

		while (option != 0) {
			if (option == 1) {
				listSales();

			} else if (option == 2) {
				System.out.println("Which suburb would you like to search for?");
				String suburb = kb.next();
				listSales(suburb);

			} else if (option == 3) {
				System.out.println("Would you like to search by minimum or maximum? \n1. Minimum \n2. Maximum \n");
				int search = kb.nextInt();
				System.out.println("Enter the price");
				double amount = kb.nextDouble();
				listSales(amount, search);

			} else if (option == 4) {

			} else {
				System.out.println("Invalid Entry");// if the user enters anything other than 1-4

			}
			System.out.println(menu);
			option = kb.nextInt();
		}
	}
	
	// Default for listing all rentals
	private void listRentals() {
		String details = "";
		for(Property p : propertyList) {
			if(p instanceof Rental) {
				details += p.getDetails();
			}
		}
		System.out.println(details);
		if(detailsCheck(details))
			chooseRental();
	}

	// Shows all rentals in the suburb specified
	private void listRentals(String suburb) {
		String details = "";
		for(Property p : propertyList) {
			if(p instanceof Rental) {
				if(p.getSuburb().equalsIgnoreCase(suburb)) {
					details += p.getDetails();
				}
			}
		}
		System.out.println(details);
		if(detailsCheck(details))
			chooseRental();
	}
	
	// Shows all rentals in the price range specified
	private void listRentals(double amount, int search) {
		String details = "";
		if(search == 1) {
			System.out.println("\nProperties with a minimum price of: " + amount + "\n");
			for(Property p : propertyList) {
				if(p instanceof Rental) {
					if(((Rental) p).getRent() >= amount) {
						details += p.getDetails();
					}
				}
			}
		}else if(search == 2) {
			System.out.println("\nProperties with a maximum price of: " + amount + "\n");
			for(Property p : propertyList) {
				if(p instanceof Rental) {
					if(((Rental) p).getRent() <= amount) {
						details += p.getDetails();
					}
				}
			}
		}
		System.out.println(details);
		if(detailsCheck(details))
			chooseRental();
	}
	
	// Method to select a rental property to apply for
	public void chooseRental() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the propId for a property you wish to apply for, or 0 to exit");
		String propId = sc.nextLine();
		if(propId.equals("0"))
			return;
		boolean choice = true;
		while(choice) {
			for(Property p : propertyList) {
				if(p instanceof Rental) {
					if(p.getPropId().equalsIgnoreCase(propId)) {
						makeApplication(p);
						choice = false;
						return;
					}
				}
			}
			System.out.println("No property exists with that propId. Please enter a propId that exists, or enter 0 to exit");
			propId = sc.nextLine();
			if(propId.equals("0"))
				choice = false;
		}
		
	}
	
	private void makeApplication(Property p) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How much rent would you like apply for?");
		double offer = sc.nextDouble();
		System.out.println("For how many months would you like to rent this property for?");
		int contract = sc.nextInt();
		p.makeApplication(offer, contract);
	}
	
	// Default for listing all for sale properties
	private void listSales() {
		String details = "";
		for(Property p : propertyList) {
			if(p instanceof Sale) {
				details += p.getDetails();
			}
		}
		System.out.println(details);
		if(detailsCheck(details))
			chooseSale();
		}
	
	// Shows all sales in the suburb specified
	private void listSales(String suburb) {
		String details = "";
		for(Property p : propertyList) {
			if(p instanceof Sale) {
				if(p.getSuburb().equalsIgnoreCase(suburb))
					details += p.getDetails();
			}
		}
		System.out.println(details);
		if(detailsCheck(details))
			chooseSale();
	}
	
	// Shows all sales in the price range specified
	private void listSales(double amount, int search) {
		String details = "";
		if(search == 1) {
			System.out.println("\nProperties with a minimum price of: " + amount + "\n");
			for(Property p : propertyList) {
				if(p instanceof Sale) {
					if(((Sale) p).getPrice() >= amount) {
						details += p.getDetails();
					}
				}
			}
		}else if(search == 2) {
			System.out.println("\nProperties with a maximum price of: " + amount + "\n");
			for(Property p : propertyList) {
				if(p instanceof Sale) {
					if(((Sale) p).getPrice() <= amount) {
						details += p.getDetails();
					}
				}
			}
		}
		System.out.println(details);
		if(detailsCheck(details))
			chooseSale();
	}
	
	// Method to select a sale property to make an offer on
	private void chooseSale() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the propId for a property you wish to make an offer on - Offer must be at least the listed price, or enter 0 to exit");
		String propId = sc.next();
		if(propId.equals("0"))
			return;
		boolean choice = true;
		while(choice) {
			for(Property p : propertyList) {
				if(p instanceof Sale) {
					if(p.getPropId().equalsIgnoreCase(propId)) {
						makeOffer(p);
						choice = false;
						return;
					}
				}
			}
			System.out.println("No property exists with that propId. Please enter a propId that exists, or enter 0 to exit");
			propId = sc.nextLine();
			if(propId.equals("0"))
				choice = false;
		}
	}
	
	private void makeOffer(Property p) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How much would you like to purchase this property for?");
		double offer = sc.nextDouble();
		p.makeOffer(offer);
	}
	
	private boolean detailsCheck(String details) {
		if(details.equals("")) {
			System.out.println("No Properties match your search criteria");
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		RealEstateManager mr = new RealEstateManager(100, 100);
		return;
	}

}
