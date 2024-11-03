package mod1CTAAssigment;

import java.util.Scanner;

public class BankAccount {    //superclass
	protected String firstName;
	protected String lastName;
	protected int accountID;                   //attributes of the bank account
	protected double balance;
	
	public BankAccount(){
		balance = 0;             //default constructor that sets balance to 0
	}
	
	public void deposit(double dollarAmount) {
		this.balance += dollarAmount;
	}
	
	
	public void withdrawal(Scanner scnr, double dollarAmount) {
		if(this.balance <= 0 || this.balance < dollarAmount) {     //checks if the current balance is less than or equal to 0 or less than the withdrawal amoount, if so it will execute
			System.out.println("insufficient funds for withdraw");
			System.out.println("would you like to overdraft for the withdrawal?(A $30 overdraft fee will be applied to your balance: ");
			String userInputWithdrawal = scnr.nextLine();
			
			if(userInputWithdrawal.equalsIgnoreCase("yes")) {     //if user says yes to a overdraft fee, the withdrawal will complete and a fee will be applied
				this.balance -= dollarAmount - 30;
				
				System.out.println(" withdrawal successful. A overdraft fee of $30 has been applied to your balance");
				System.out.println("New Balance: " + this.balance);
			}else {
				System.out.println("A overdraft will not be applied to your balance");
			}
		}else if(this.balance > 0 || this.balance > dollarAmount) {      //if current balance is greater than 0 it will execute
			this.balance = this.balance - dollarAmount;
			System.out.println("new Balance: " + this.balance);
			
		}
		
	
	}
	
	
	
	public void setFirstName(String firstName) {       // block of setters for bank account attributes
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
	
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}                                         // block of getters for bank account attributes
	public int getAccountID() {
		return this.accountID;
	}
	public double getBalance() {
		return this.balance;
	}
	
	public void accountSummary() {
		System.out.println("First Name: " + getFirstName());
		System.out.println("Last Name: " + getLastName());              //method that prints all bank account information
		System.out.println("Account ID: " + getAccountID());
		System.out.println("Balance: " + getBalance());
		
	}
	
	
	
}
