package bankaccapp;

import java.util.LinkedList;
import java.util.List;
import java.util.*;

public class BankAccountApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * List to store the accounts (either Checking or Savings)
		 * Created by reading the CSV file
		 * */
		List<Account> accounts =  new LinkedList<>();
		
		/* Read CSV file and then create new accounts base on that data 
		 * using VSV read().
		 * The returned list by read() will be assigned a to a new 
		 * list which will be used to loop through it and  create the accounts
		 * Alternative CSV.read("NewBankAccounts.csv")
		 * can be pass directly to the for-each
		 * */
		List <String[]> list = new LinkedList<>(CSV.read("NewBankAccounts.csv"));
		
		/* 
		 * Looping through the list returned by read()
		 * using the index to access the information
		 * */
		for(String[] accountHolder : list) {
			String name = accountHolder[0];
			String sSN = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);
			
			// If account type equals Savings create a new Savings acc
			if(accountType.equals("Savings")) {
				accounts.add(new Savings(name, sSN, initDeposit));
				
			// If account type equals Checking create a new Checking acc	
			} else if (accountType.equals("Checking")){
				accounts.add(new Checking(name, sSN, initDeposit));
				
			// Else there was an error	
			} else {
				System.out.println("Error Reading the Account type");
			}
			
		}
		
		System.out.println("----------------------");
		
		// For-each printing all the accounts created to confirm it work
		for(Account account : accounts) {
			account.showInfo();
			System.out.println("\n");
		}
		
		System.out.println("*************************\n");
		
		/*
		 * Getting a random account holder
		 * and confirm methods are working as expected
		 * */
		Account acc1 = accounts.get((int) (Math.random()*accounts.size()));
		acc1.showInfo();
		System.out.println("-");
		acc1.deposit(1500);
		System.out.println("-");
		acc1.withdraw(300000);
		System.out.println("-");
		acc1.transfer("IEAIBK4762342", 300);
		
		
	}

}
