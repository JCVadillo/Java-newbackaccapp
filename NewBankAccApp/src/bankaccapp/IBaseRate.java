package bankaccapp;

public interface IBaseRate {
	
	// write a method that return the BaseRate
	
	default double getBaseRate() {
		return 2.5;
	}
}
