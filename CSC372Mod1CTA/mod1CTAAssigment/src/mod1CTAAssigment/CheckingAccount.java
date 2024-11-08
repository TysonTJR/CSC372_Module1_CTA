package mod1CTAAssigment;

import java.util.Scanner;

public class CheckingAccount extends BankAccount {   //subclass that inherits from BankAccount.Java
	private double interestRate = 0.02; //interest rate attribute to 2%
	private int overDraftFee = 30;  //overdraft fee of the checking account if a withdraw occurs
	
	public double getInterestRate() {
		return this.interestRate;
	}
	
	
	public int getOverDraftFee() {
		return this.overDraftFee;
	}
	
	public CheckingAccount() {  //default constructor that creates a checking account
		
	}
	
	public void processWithdrawal(Scanner scnr, double dollarAmount) {
		if(this.balance <= 0 || this.balance < dollarAmount) {     //checks if the current balance is less than or equal to 0 or less than the withdrawal amoount, if so it will execute
			System.out.println("insufficient funds for withdraw");
			System.out.println("would you like to overdraft for the withdrawal?(A $30 overdraft fee will be applied to your balance: ");
			String userInputWithdrawal = scnr.nextLine();
			
			if(userInputWithdrawal.equalsIgnoreCase("yes")) {     //if user says yes to a overdraft fee, the withdrawal will complete and a fee will be applied
				this.balance = this.balance - dollarAmount - getOverDraftFee();
				
				System.out.println("withdrawal successful. A overdraft fee of $30 has been applied to your balance");
				System.out.println("New Balance: " + this.balance);
			}else {
				System.out.println("A overdraft will not be applied to your balance");
			}
		}else if(this.balance > 0 || this.balance > dollarAmount) {      //if current balance is greater than 0 it will execute
			this.balance = this.balance - dollarAmount;
			System.out.println("new Balance: " + this.balance);
			
		}
		
	}
	public void displayAccount() {
		System.out.println("First Name: " + getFirstName());
		System.out.println("Last Name: " + getLastName());        //method that displays account information
		System.out.println("Account ID: " + getAccountID());
		System.out.println("Balance: " + getBalance());
		System.out.println("Interest Rate: " + getInterestRate());
	}
	


}

