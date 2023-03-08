package bankaccapp;

public class Checking extends Account{
	// List properties specific to the Checking account
	private DebitCard card;
	
	// Constructor to initialise checking acc. properties
	public Checking(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		accountNumber = "2" + accountNumber;
		card = new DebitCard();
		setRate();
	}
	
	// List of methods to the checking account
	
	// Method to print the account info plus properties specific to the Checking account
	public void showInfo() {
		super.showInfo();
		System.out.println("Your Checking account features: " + 
						   "\nDebit Card: " + card.getDebitCardNumber() +
						   "\nDebit Card Pin: " + card.getDebitCardPin() +
						   "\nYour Interest Rate is: " + rate + "%");
	}
	
	//Set the interest rate for checking accs
	@Override
	public void setRate() {
		rate = getBaseRate() * .15;
	}
}
