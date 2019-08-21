

public class RealEstateManager {
	private int maxAccounts;
	private int maxProperties;
	private Account[] accountList;
	private Property [] propertyList;
	private int accountNum;
	private int propertyNum;
	public RealEstateManager(int maxAccounts, int maxProperties) {
		this.maxAccounts = maxAccounts;
		this.maxProperties = maxProperties;
		this.accountList = new Account[this.maxAccounts];
		this.propertyList = new Property[this.maxProperties];
		this.accountNum = 0;
		this.propertyNum = 0;
		startLogin();
		return;
	}

	private void startLogin() {
		
			String menu = "Login\nPlease Make a Selection:\n1. Login\n2. Create Account\nTo locate account details \nplease talk to one of our staff";
			String option = JOptionPane.showInputDialog(menu);
			while (option != null) {// as long as a user doesn't cancel it the menu will appear
				if (option.matches("[1-2]")) {// if the input is not 1-4 it is invalid
					int optionInt = Integer.parseInt(option);

					if (optionInt == 1) {
						checkLogin();

					} else if (optionInt == 2) {
						createAccount();

					} else {
						JOptionPane.showMessageDialog(null, "Invalid Entry");// if the user enters anything other than 1-4

					}
				}
				
				option = JOptionPane.showInputDialog(menu);
			}

			return;

		
		
	}

	public static void main(String[] args) {

		RealEstateManager mr = new RealEstateManager(100, 100);
		return;
	}

}
