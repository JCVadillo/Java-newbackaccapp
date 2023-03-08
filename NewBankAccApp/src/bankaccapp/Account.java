package bankaccapp;

public abstract class Account implements IBaseRate{
	// List of common properties for Savings and checking
	private String name;
	private String sSN;
	private double balance;
	protected  String accountNumber;
	protected double rate;
	private static int index = 10001;
	
	
	// Constructor to set base Properties and initialised the account
	public Account(String name, String sSN, double initDeposit) {
		this.name = name;
		this.sSN = sSN;
		this.balance = initDeposit;
		this.accountNumber = setAccountNumber();
		index++;
		
	}
	// List of common methods
	
	//Set Rate has to be implemented by 
	public abstract void setRate();
	
	//Set account number method
	private String setAccountNumber() {
		String lasttwosSN = sSN.substring(sSN.length()-2, sSN.length());
		int uniqueID = index;
		int randomNumber = (int) (Math.random() * Math.pow(10, 3));
		return lasttwosSN + uniqueID + randomNumber;
	}
	
	//Calculate compound interest
	public void compoundInterest() {
		double accuredInterest = balance * (rate/100);
		balance += accuredInterest;
		System.out.println("Accured Interest: $" + accuredInterest);
		printBalance();
	}
	
	//Deposit method
	public void deposit(double amount) {
		balance += amount;
		System.out.println("Deositing: $" + amount);
		printBalance();
	}
	
	//Withdraw method
	public void withdraw (double amount) {
		if(balance < amount) {
			System.out.println("You don't have enough for the operation");
		}else {
			System.out.println("Withdrawing: $" + amount);
			balance -= amount;
			}
		printBalance();
	}
	
	//Transfer method
	public void transfer (String toWhere, double amount) {
		if(balance < amount) {
			System.out.println("You don't have enough for the operation");
		}else {
			System.out.println("Transfering: $" + amount + " to: " + toWhere );
			balance -= amount;
			}
		printBalance();
	}
	
	//Printing the balance 
	public void printBalance() {
		System.out.println("Your balance is: $" + balance);
	}
	
	//Show info method
	public void showInfo() {
		System.out.println(
				"Name: " + name+
				"\nAccount Number: " + accountNumber +
				"\nBalance: " + balance);
	}
}
