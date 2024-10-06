package PortfolioProject;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;





public class Main {
	public static void main(String[] args) throws IOException {
		
		Scanner scnr = new Scanner(System.in);         // creating scanner object
		String userDir = System.getProperty("user.dir");  //getting current user directory in order to create a file in a correct path
		String filename = "VehicleInventorySave.txt";   //file name
		String filePath = userDir + "/" + filename;    // the file path way
		File firstFile = new File(filePath);    //creating the file
		boolean decisonToCreateFile = false;    //
		
		try {
			try {
				System.out.println("Hi welcome to the Vehicle Inventory Program.");
				System.out.println("This program will attempt to create a new save file for the vehicle inventory if it doesn't aleady exists.");
				System.out.println("Is this ok?(yes will then check if the file exists or not/ no will no create a new file save: ");   //beginning prompt of program
				String userInput = scnr.nextLine();
				System.out.println("");
		
				if(userInput.equalsIgnoreCase("yes")) {      // if statement which decides whether or not to check if a file exists, if it does it continues, if not it creates one
					decisonToCreateFile = true;
					try {
						boolean isFileCreated = firstFile.createNewFile();
			
						if(isFileCreated == true) {
							System.out.println("(Success, new save file has been created");
							System.out.println("");
	
						}else if(isFileCreated == false) {
							System.out.println("VehicleInventorySave.txt file already exists");
							System.out.println("");

						}
			
					} catch (IOException e) {    //try catch block that will catch any IO exception
						System.out.println("Failure");
						e.printStackTrace();
					}
					
			
				}else if(userInput.equalsIgnoreCase("no") && decisonToCreateFile == false) {    //if user entered no, no file will be created
					System.out.println("Ok, a new file will not be created");
					System.out.print("");
				}
				
			}catch(InputMismatchException e){
				System.out.println("Failure");
				e.printStackTrace();
			}
		
	ArrayList<Vehicle> vehicleInventory = new ArrayList<Vehicle>();    //creating the arraylist which will act as the vehicle inventory
	boolean doesFileExist = firstFile.exists();      //checks if file exists
	try (BufferedReader fileReader = new BufferedReader(new FileReader(firstFile))) {    //creates a buffered reader which can be used to read files
		if(doesFileExist && fileReader.ready()) {    //checks if the file exists and ir it has content within it. does not execute when empty
			
			try {
				int i = -1;
				int n = 1;
				String line = fileReader.readLine();    //creating varible to hold the line being read in the file
				String[] wordsInLine = line.split(" ");   //splits the line being read in the file into indivuals words in a array by using the split method 
				
				
				
			
				System.out.println(" Loaded Vehicle Inventory: ");
				System.out.println("");
				do{                                          //do while loop which adds each parameter in the file to the number of vehicle objects caculated. 
					String autoMake = wordsInLine[i + n];
					i = i + n;
					String autoModel = wordsInLine[i + n];
					i = i + n;
					String autoColor = wordsInLine[i + n];
					i = i + n;
					String autoYear = wordsInLine[i+ n];
					i = i + n;
					String autoMileage = wordsInLine[i + n];
					i = i + n;
					
					
				
					Vehicle newVehicle = new Vehicle(autoMake, autoModel, autoColor,autoYear , autoMileage);   //creates vehicle object
					vehicleInventory.add(newVehicle);   //adds vehicle object to inventory
					
					
					
					i = i + 0;
					if(wordsInLine[i -1].equalsIgnoreCase("*")){    //ends reading line by checking if a / occurs, if it does, it ends
						break;
					}
				}while(doesFileExist);    //do while loop executes when doesfileexist is true
				
				
				}catch(ArrayIndexOutOfBoundsException e) {
					
				}
			
		}
	}
		

		int menuLoopChoice = -1;
		boolean menuLoopDecision = menuLoopChoice == -1;
		String userInputString = "none";
		
menuLoop: while(menuLoopDecision){
				System.out.println("");
				System.out.println("What would you like to do?/Enter number of what you would like to do/: ");
				System.out.println("");
				System.out.println("1. Add a vehicle to inventory: ");
				System.out.println("");
				System.out.println("2. Update a vehicle in inventory: ");         //this is the main menu
				System.out.println("");
				System.out.println("3. remove vehicle from inventory: ");
				System.out.println("");
				System.out.println("4. list vehicles from inventory: ");
				System.out.println("");
				System.out.println("5. Save vehicle Inventory to a file");
				System.out.println("");
				System.out.println("enter number: ");
				
				try {
				menuLoopChoice = scnr.nextInt();
				scnr.nextLine();
				
				}catch(InputMismatchException e){	
					System.out.println("");
					System.out.println("(failure)");
					System.out.println("");
					System.out.println("(Incorrent data type, please input an integer from 1 to 4)");
					System.out.println("");
					scnr.nextLine();
				}

switchLoop:	switch(menuLoopChoice){      //switch loop which corresponds to the main menu, comparing the menuloopchoice varailbe to different values

					case 1:     //case 1 adds a vehicle
						try {
						String userInputCase1 = "none";
						addVehicleLoop: while(userInputCase1.equalsIgnoreCase("none")){
											System.out.println("Success");
											System.out.println("");
											Vehicle.addVehicle(vehicleInventory, scnr);
											
											System.out.println("");
											System.out.println("Would you like to add another vehicle?: ");
											userInputString = scnr.nextLine();
											
											if(userInputString.equalsIgnoreCase("yes")) {
								
												userInputCase1 = "none";
												continue addVehicleLoop;
											}else {
												System.out.print("Would you like to see the menu again?: ");
												userInputString = scnr.nextLine();
												if(userInputString.equalsIgnoreCase("yes")) {
													
													continue menuLoop;
													
												}else {
													
													break menuLoop;
													
												}
												
											}
										}	
						}catch(InputMismatchException e) {
							System.out.println("(failure)");
							e.printStackTrace();
						}
						
					case 2:    //case 2 updates a vehicle
						String userInputCase2 = null;
						updateVehicleLoop: do{
											try {
												System.out.println("(Success)");
												System.out.println("");
												Vehicle.updateVehicle(scnr,vehicleInventory);
												System.out.print("");
											
												System.out.println("Would you like to update another vehicle?: ");
												userInputString = scnr.nextLine();
						
												if(userInputString.equalsIgnoreCase("yes")) {
			
													userInputCase2 = "none";
													continue updateVehicleLoop;
												}else {
													System.out.print("Would you like to see the menu again?: ");
													userInputString = scnr.nextLine();
													if(userInputString.equalsIgnoreCase("yes")) {
														continue menuLoop;
													}else {
													break menuLoop;
													}
												}
											}catch(InputMismatchException e) {
											System.out.println("(failure)");
											e.printStackTrace();
										}
											}while(userInputCase2.equalsIgnoreCase("none"));	
										
					case 3:    //case 3 removes a vehicle
						String userInputCase3 = null;
						
						removeVehicleLoop: do{
											System.out.println("(Success)");
											System.out.println("");
											Vehicle.removeAuto(scnr, vehicleInventory);
											System.out.println("Would you like to remove another vehicle?: ");
											userInputString = scnr.nextLine();
						
											if(userInputString.equalsIgnoreCase("yes")) {
			
												userInputCase3 = "none";
												continue removeVehicleLoop;
											}else {
												System.out.print("Would you like to see the menu again?: ");
												userInputString = scnr.nextLine();
												if(userInputString.equalsIgnoreCase("yes")) {
													
													continue menuLoop;
								
												}else {
													
													break menuLoop;
								
												}
											}
											}while(userInputCase3.equalsIgnoreCase("none"));
						
					case 4: //case 4 list the vehicles
						String userInputCase4 = null;
						listVehicleLoop: do{
											System.out.println("(Success)");
											Vehicle.listVehicle(vehicleInventory);
											System.out.println("Would you like to list the vehicles again?: ");
											userInputString = scnr.nextLine();
		
											if(userInputString.equalsIgnoreCase("yes")) {

												userInputCase4 = "none";
												continue listVehicleLoop;
											}else {
												System.out.print("Would you like to see the menu again?: ");
												userInputString = scnr.nextLine();
												if(userInputString.equalsIgnoreCase("yes")){
									
													continue menuLoop;
				
												}else {
									
													break menuLoop;
				
												}
											}
											}while(userInputCase4.equalsIgnoreCase("none"));
		
					case 5:   //case 5 saves the vehicle inventory to a file
						System.out.println("Would you like to save the vehicle inventory to a file(Enter y for yes and n for no)?");
						String finalUserInput = scnr.nextLine();
						int i;
						if(finalUserInput.equalsIgnoreCase("y")) {
							try (FileWriter writeToFile = new FileWriter(firstFile, false)) {
								for(i = 0; i < vehicleInventory.size(); i++) {
									String vehicleYear = Vehicle.getAutoYear(vehicleInventory, i);
					
									String  vehicleMileage = Vehicle.getAutoMileage(vehicleInventory, i);
									
									
									writeToFile.write(Vehicle.getAutoMake(vehicleInventory, i) + " " 
									+ Vehicle.getAutoModel(vehicleInventory, i) + " "
									+ Vehicle.getAutoColor(vehicleInventory, i) + " "
									+ vehicleYear + " "
									+ vehicleMileage);

								}
								writeToFile.write("*");
							}
							System.out.println("inventoy saved");
						}
						else if(finalUserInput.equalsIgnoreCase("n")) {
							System.out.println("Ok, the vehicle inventory will not be saved");
							System.out.print("");
							}
								
				}
									
				menuLoopChoice = 1;
			}

			scnr.close();    //closing the scanner resource
		
	}catch(Exception e) {
		System.out.println("Failure");
		e.printStackTrace();
	}
	}
}