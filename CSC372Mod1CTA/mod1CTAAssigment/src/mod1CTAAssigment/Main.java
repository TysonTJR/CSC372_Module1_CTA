package mod1CTAAssigment;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);


		
		System.out.println("Would you like to create a general bank account or a checking account?:(1 or general and a 2 for a checking account) ");
		String userInputBankType = scnr.nextLine();
		
		if(userInputBankType.equalsIgnoreCase("1")) {      // if user enters 1 then creates a general bank account
			BankAccount generalBankAccount = new BankAccount();
			System.out.println("Set first name for a general bank account: ");
			String userInputFirstName = scnr.nextLine();
			generalBankAccount.setFirstName(userInputFirstName);      //sets first name of the account to the user input
		
			System.out.println("Set last name for a general bank account: ");
			String userInputLastName = scnr.nextLine();
			generalBankAccount.setLastName(userInputLastName);      //sets last name of the account to the user input
		
		
			boolean loopChoice = true;          // conditional boolean variable for the account ID loop
			accountIDLoop: while(loopChoice) {   //while variable is true executes
		
								System.out.println("Set account Id for a general bank account(Enter 8 digits:) ");
								int userInputAccountID = scnr.nextInt();
								
								if(userInputAccountID > 0) {
									String userInputAccountIDConvert = Integer.toString(userInputAccountID);   //converts user int to a string
		
									if(userInputAccountIDConvert.matches("\\d{8}")){         //checks to make sure the acccount ID is 8 digits
										generalBankAccount.setAccountID(userInputAccountID);
										loopChoice = false;
										break;
								
									}else {                                             //if account Id is not 8 digits it continues the loop
										System.out.println("(Please enter 8 digits)");
										continue accountIDLoop;
									}
								}else if(userInputAccountID <= 0) {
									System.out.println("(ERROR. Please enter only positive integers)");
								}
							}
		
		System.out.println("Enter a deposit for your new general bank account: ");          //prompts the user to enter a deposit
		double userInputBalance = scnr.nextDouble();
		generalBankAccount.deposit(userInputBalance);                //method that adds the deposit to the account balance
		
		scnr.nextLine();
		System.out.println("Would you like to see a general bank account summary?: ");   //asks the user if they want to see a summary
		String userInputChoice = scnr.nextLine();
		
		if(userInputChoice.equalsIgnoreCase("yes")) {
			generalBankAccount.accountSummary();
			scnr.nextLine();
		}else {
			
			System.out.println("would you like to make a withdraw?: ");
			String userInputWithdrawChoice = scnr.nextLine();
			
			if(userInputWithdrawChoice.equalsIgnoreCase("yes")){
				Double userInputWithdrawal = 0.0;    //initially setting the withdrawal amount to 
				System.out.println("Enter how much you would like to withdrawal from your account: ");
				userInputWithdrawal = scnr.nextDouble();   //setting the withdrawal amount with user input
				
				generalBankAccount.withdrawal(scnr, userInputWithdrawal);
			}else {
				
			}
		}
		
		
		
	
		
		}else if(userInputBankType.equalsIgnoreCase("2")) {              //if user chooses to create a checking account
			CheckingAccount checkingAccount = new CheckingAccount();     //creates a checking account object
			System.out.println("Set first name for a checking account: ");
			String userInputFirstName = scnr.nextLine();
			checkingAccount.setFirstName(userInputFirstName);          //sets the first name of checking account
		
		
			System.out.println("Set last name for a checking account: ");
			String userInputLastName = scnr.nextLine();
			checkingAccount.setLastName(userInputLastName);             //sets the last name of the checking account
		
		
			boolean loopChoice = true;
			accountIDLoop: while(loopChoice) {            //loop for accountID. Used for error handling
		
								System.out.println("Set account Id for a checking account(Enter 8 digits: ");
								int userInputAccountID = scnr.nextInt();
								String userInputAccountIDConvert = Integer.toString(userInputAccountID); //converts user int input to a string
		
								if(userInputAccountIDConvert.matches("\\d{8}")){      //checks to see if user input is 8 digits, if so it sets the input to the account id
									checkingAccount.setAccountID(userInputAccountID);
									loopChoice = false;
									break;
								
								}else {     //if user input is not 8 digits it continues the loop asking to enter 8 digits
									System.out.println("Please enter 8 digits");
									continue accountIDLoop;
								}
		
							}
		
			System.out.println("Enter a deposit for your new checking account: ");
			double userInputBalance = scnr.nextDouble();
			checkingAccount.deposit(userInputBalance);        //adds a deposit to the current checking account balance
		
			scnr.nextLine();
			System.out.println("Would you like to see a checking account summary?: ");
			String userInputChoice = scnr.nextLine();
		
			if(userInputChoice.equalsIgnoreCase("yes")) {
				checkingAccount.displayAccount();          //displays all superclass bankaccount info plus the interest rate of the checking account
				scnr.nextLine();
			}else {
				
				System.out.println("would you like to make a withdraw?: ");
				String userInputWithdraw = scnr.nextLine();
			
				if(userInputWithdraw.equalsIgnoreCase("yes")){     //if user enters yes, it will enter a withdrawal process
					Double userInputWithdrawal = 0.0;    //initially setting the withdrawal amount to 
					System.out.println("Enter how much you would like to withdrawal from your account: ");
					userInputWithdrawal = scnr.nextDouble();   //setting the withdrawal amount with user input
					
					scnr.nextLine();
					checkingAccount.processWithdrawal(scnr, userInputWithdrawal) ;  //calls the withdrawal method
				}else {
				
				}
			}
		
		}
		scnr.close();
	}
}
