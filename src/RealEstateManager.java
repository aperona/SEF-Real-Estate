import java.util.Scanner;

public class RealEstateManager {
	private int maxAccounts;
	private int maxProperties;
	private Account[] accountList;
	private Property[] propertyList;
	private int accountNum;
	private int propertyNum;
	int accessAccount;//position of the current logged in account on array

	public RealEstateManager(int maxAccounts, int maxProperties) {
		this.maxAccounts = maxAccounts;
		this.maxProperties = maxProperties;
		this.accountList = new Account[this.maxAccounts];
		this.propertyList = new Property[this.maxProperties];
		this.accountNum = 0;
		this.propertyNum = 0;
		this.accessAccount= 0;
		startLogin();
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

	private void checkLogin() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter Your Username:");
		String username = kb.nextLine();
		System.out.println("Enter Your Password:");
		String password = kb.nextLine();
		int i = 0;
		while (i < this.accountNum) {
			if ((this.accountList[i]).getUsername().equals(username)
					&& (this.accountList[i]).getPassword().equals(password)) {

				System.out.println( "Success!");
				
				if ((this.accountList[i]) instanceof Customer) {
					//accessLevel = 0;
					accessAccount = i;
					openMenu();

				}
				if ((this.accountList[i]) instanceof Employee) {
					//accessLevel = 1;
					accessAccount = i;
					openMenu();
				}


			}

			i++;
		}
		return;

	}

	private void openMenu() {
		Scanner kb = new Scanner(System.in);
		String menu = "Main Menu\nPlease Make a Selection:\n1. Account Management\nType 0 to log out";
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
		boolean landLord = false;
		if (option.matches("y")) {
			landLord = true;
		}
		System.out.println("Are you a vendor y/n");
		option = kb.nextLine();
		boolean vendor = false;
		if (option.matches("y")) {
			vendor = true;
		}
		addCustomer(username,email,password,name,surname,phNumber,landLord,vendor);
		return;

	}

	private void addCustomer(String username, String email, String password, String name, String surname,
			String phNumber, boolean landLord, boolean vendor) {
		this.accountList[this.accountNum] = new Customer(username,email,password,name,surname,phNumber,landLord,vendor);
		this.accountNum += 1;

		return;
		
	}

	public static void main(String[] args) {

		RealEstateManager mr = new RealEstateManager(100, 100);
		return;
	}

}
