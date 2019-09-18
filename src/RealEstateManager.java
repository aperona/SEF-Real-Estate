import java.util.*;
import java.io.*;

public class RealEstateManager {
	private int maxAccounts;
	private int maxProperties;
	private Account[] accountList;
	private Property[] propertyList;
	private int accountNum;
	private int propertyNum;
	int accessAccount;// position of the current logged in account on array

	public RealEstateManager(int maxAccounts, int maxProperties) {
		this.maxAccounts = maxAccounts;
		this.maxProperties = maxProperties;
		this.accountList = new Account[this.maxAccounts];
		this.propertyList = new Property[this.maxProperties];
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
//				if (fields[2].equals("Employee")) {
//					addEmployee(fields[0], fields[1], fields[2], fields[4], fields[5], fields[6], fields[7]);
//
//					((Employee) this.personList[this.personNum - 1]).setType(fields[3]);
//
//
//				}
//				if (fields[2].equals("Admin")) {
//
//					addAdmin(fields[0], fields[1]);
//
//				}
				input = load.readLine();
			}

			load.close();
		}
		// if there is no person data available the program assumes that it is being ran
		// for the first time and creates a admin account
		catch (Exception e) {
			System.out.println(
					"Error! " + e.getMessage() + "\n No account data\nCreating Admin Account");
		//	createAdminPerson();
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
		String menu = "Login\nPlease Make a Selection:\n1. Login\n2. Create Account\nTo locate account details \nplease talk to one of our staff";
		System.out.println(menu);
		int option = kb.nextInt();
		// as long as a user doesn't cancel it the menu will appear

		while (option != 0) {
			if (option == 1) {
				System.out.println("Login");
				System.out.println("Enter Your Username:");
				String username = kb.nextLine();
				System.out.println("Enter Your Password:");
				String password = kb.nextLine();
				checkLogin(username, password);

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

	void checkLogin(String username, String password) {

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
		String menu = "Main Menu\nPlease Make a Selection:\n1. Account Management\nType 0 to log out";
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

	private void addCustomer(String username, String email, String password, String name, String surname,
			String phNumber, String landLord, String vendor) {
		this.accountList[this.accountNum] = new Customer(username, email, password, name, surname, phNumber, landLord,
				vendor);
		this.accountNum += 1;

		return;

	}

	public static void main(String[] args) {

		RealEstateManager mr = new RealEstateManager(100, 100);
		return;
	}

}
