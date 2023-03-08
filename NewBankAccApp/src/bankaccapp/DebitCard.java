package bankaccapp;

public class DebitCard {
	
	private long debitCardNumber;
	private int debitCardPin;
	
	public DebitCard() {
		setDebitCardNumber();
		setDebitCardPin();
	}
	
	// Getters and Setters
	public long getDebitCardNumber() {
		return debitCardNumber;
	}
	private void setDebitCardNumber() {
		this.debitCardNumber = (long) (Math.random() * Math.pow(10, 12));
	}
	public int getDebitCardPin() {
		return debitCardPin;
	}
	private void setDebitCardPin() {
		this.debitCardPin = (int) (Math.random() * Math.pow(10, 4));
	}
	
	
}
