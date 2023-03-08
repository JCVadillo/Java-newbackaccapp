package bankaccapp;

public class SafetyDepositBox {
	
	private int safeDepositBoxID;
	private int safeDepositBoxKey;
	
	public SafetyDepositBox() {
		setSafeDepositBoxID();
		setSafeDepositBoxKey();
	}
	

	public int getSafeDepositBoxID() {
		return safeDepositBoxID;
	}
	private void setSafeDepositBoxID() {
		this.safeDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
		
	}
	public int getSafeDepositBoxKey() {
		return safeDepositBoxKey;
	}
	private void setSafeDepositBoxKey() {
		safeDepositBoxKey = (int) (Math.random() * Math.pow(10,4));
	}
	
}
