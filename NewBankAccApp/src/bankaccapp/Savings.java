package bankaccapp;

public class Savings extends Account {
	// List properties specific to the savings account
	private SafetyDepositBox sdb;
	
	// Constructor to initialise savings account. properties
	public Savings(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		accountNumber = "1" + accountNumber;
		sdb = new SafetyDepositBox();
		setRate();
	}

	// List of methods to the savings account
	
	
	public void showInfo() {
		super.showInfo();
		System.out.println("Your Savings account features: " +
						   "\nSafety Deposit Box: " + sdb.getSafeDepositBoxID()+
						   "\nSafety Deposit Key: " + sdb.getSafeDepositBoxKey() +
						   "\nYour Interest Rate is: " + rate + "%");
	}

	@Override
	public void setRate() {
		rate = getBaseRate() - .25;
	}
}
