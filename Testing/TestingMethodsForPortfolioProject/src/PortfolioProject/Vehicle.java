package PortfolioProject;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Vehicle {
	private String autoMake;
	private String autoModel;
	private String autoColor;
	private String autoYear;
	private String autoMileage;
	
	
	public Vehicle() {     //default vehicle constructor
		
	}
	
	public Vehicle(String make, String model, String color, String year, String mileage) {    //parameterized constructor
		autoMake = make;
		autoModel = model;
		autoColor = color;
		autoYear = year;
		autoMileage = mileage;
		
	}
	
	private void setAutoMake(String newValue) {
		try {
			this.autoMake = newValue;
		
		}catch(InputMismatchException e) {
			e.printStackTrace();
		}
	}
	private void setAutoModel(String newValue) {
		try {
			this.autoModel = newValue;
		
		}catch(InputMismatchException e) {
		e.printStackTrace();                                                  //block of setter methods for vehicle attributes
	}
	}
	private void setAutoColor(String newValue) {
		try {
			this.autoColor = newValue;
		}catch(InputMismatchException e) {
			e.printStackTrace();
		}
	}
	private void setAutoYear(String newValue) {
		try {
			this.autoYear = newValue;
		}catch(InputMismatchException e) {
			e.printStackTrace();
		}
	}
	private void setAutoMileage(String newValue) {
		try {
			this.autoMileage = newValue;
		}catch(InputMismatchException e) {
			e.printStackTrace();
		}
	}
	
	public static String getAutoMake(ArrayList<Vehicle> vehicleInventory, int i) {
	
		return vehicleInventory.get(i).autoMake;
	}
	public static String getAutoModel(ArrayList<Vehicle> vehicleInventory, int i) {
		return vehicleInventory.get(i).autoModel;
	}
	public static String getAutoColor(ArrayList<Vehicle> vehicleInventory, int i) {
		return vehicleInventory.get(i).autoColor;
	}                                                                                          //block of getter methods for vehicle attributes
	public static String getAutoYear(ArrayList<Vehicle> vehicleInventory, int i) {
		return vehicleInventory.get(i).autoYear;
	}
	public static String getAutoMileage(ArrayList<Vehicle> vehicleInventory, int i) {
		return vehicleInventory.get(i).autoMileage;
	}
	
	public static void addVehicle(ArrayList<Vehicle> vehicleInventory, Scanner scnr) {                //method for adding vehicles
		try {
			String userInputMake;
			String userInputModel;
			String userInputColor;
			String userInputYear;
			String userInputMileage;
			
			System.out.println("Enter vehicle make: ");
			userInputMake = scnr.nextLine();
			


			System.out.println("Enter vehicle model: ");
			userInputModel = scnr.nextLine();
			


		
			System.out.println("Enter vehicle color: ");
			userInputColor = scnr.nextLine();
		

			System.out.println("Enter vehicle year: ");	
			userInputYear = scnr.nextLine();
		

			System.out.println("Enter vehicle mileage: ");		
			userInputMileage = scnr.nextLine();
		
		

			Vehicle newvehicle = new Vehicle(userInputMake, userInputModel, userInputColor, userInputYear, userInputMileage);
			vehicleInventory.add(newvehicle);
		
			Vehicle.listVehicle(vehicleInventory);
			
		}catch(InputMismatchException e) {
			System.out.println("Failure");
			System.out.println("Please enter correct values for vehicle parameters.");
			System.out.println("");
			System.out.println("Model: name");
			System.out.println("Make: name");
			System.out.println("Color: name");
			System.out.println("Year: year");
			System.out.println("Mileage: year");

		}
		
	
	}
	public static void removeAuto(Scanner scnr, ArrayList<Vehicle> vehicleInventory ) {                      //method for removing vehicles
		int i;
		try {
		String userInputMake = "none";
		String userInputModel;
		String userInputColor;
		String userInputYear;
		String userInputMileage;
		
		while(userInputMake.equalsIgnoreCase("none")) {
			
				System.out.println("Enter vehicle informtion for vehicle you want to remove: ");
				System.out.println("make: ");
				userInputMake = scnr.nextLine();
				System.out.println("model: ");
				userInputModel = scnr.nextLine();
				System.out.println("Color: ");	
				userInputColor = scnr.nextLine();                  //prompts user for vehicle they want to remove
				System.out.println("Year: ");	
				userInputYear = scnr.nextLine();
				System.out.println("Mileage: ");	
				userInputMileage = scnr.nextLine();
		
			
				for(i = vehicleInventory.size() - 1; i >= 0; i--) {
					String currVehicleMake = getAutoMake(vehicleInventory, i);
					String currVehicleModel = getAutoModel(vehicleInventory, i);           //delcaring and assigning variables to each current vehicle parameter
					String currVehicleColor = getAutoColor(vehicleInventory, i);
					String currVehicleYear = getAutoYear(vehicleInventory, i);
					String currVehicleMileage = getAutoMileage(vehicleInventory, i);
				
				
					if(userInputMake.equalsIgnoreCase(currVehicleMake) 
						&& userInputModel.equalsIgnoreCase(currVehicleModel)
						&& userInputColor.equalsIgnoreCase(currVehicleColor)     //checks to see if userinput for each parameter matche the current vehicle object parameters
						&& userInputYear.equalsIgnoreCase(currVehicleYear)
						&& userInputMileage.equalsIgnoreCase(currVehicleMileage)) {
								
						vehicleInventory.remove(i);         //if true removes that particular vehicle and then breaks loop
						System.out.println("Successfully removed vehicle");
						Vehicle.listVehicle(vehicleInventory);
						break;
						
					}
					else if(!userInputMake.equalsIgnoreCase(currVehicleMake) 
						&& !userInputModel.equalsIgnoreCase(currVehicleModel)
						&& !userInputColor.equalsIgnoreCase(currVehicleColor)     //checks to see if userinput for each parameter matche the current vehicle object parameters
						&& !userInputYear.equalsIgnoreCase(currVehicleYear)
						&& !userInputMileage.equalsIgnoreCase(currVehicleMileage)) {
						System.out.println("Match not found");           //if userinput is not matched to a vehicle, then prints match not found
						
					}
			
				}
			
		}
		}catch(InputMismatchException e){
			System.out.println("Failure");               //catches exception if userinput is not a string
			e.printStackTrace();
		}
	}
	
	
	public static void listVehicle (ArrayList<Vehicle>vehicleInventory) {        //method for listing vehicles in the vehicle inventory
		try {
			if(vehicleInventory.isEmpty()) {
				System.out.println("No vehicle is in the inventory");              // if inventory is empty then prints no vehicle in inventory
				System.out.println("");

		}else {          //if not empty then prints each paramters for each vehicle object in the inventory
			for(Vehicle iterate: vehicleInventory) {
				System.out.println("Make: " + iterate.autoMake + "," + " " + "Model: " +
				iterate.autoModel + "," + " "+ "Color: " +  iterate.autoColor + "," + " "+ "Year: " +  iterate.autoYear + "," + " "+ " Mileage: " +  iterate.autoMileage);
			}
		}
		
		}catch(Exception e) {
			System.out.println("failure");       //catches any exception that may occur then print it to the console along with "failure"
			e.printStackTrace();
		}
	}
	
	
	public static int findOriginalVehicleInArrayList(Scanner scnr, ArrayList<Vehicle>vehicleInventory) { //method for finding the userinputted vehicle object's index in the vehicle inventory
		try {
			int i;
			String originaluserInputMake = "none";
			String originaluserInputModel= "none";
			String originaluserInputColor= "none";
			String originaluserInputYear= "none";
			String originaluserInputMileage= "none";
		
			System.out.println("Enter vehicle informtion for vehicle you want to update: ");
			System.out.println("make: ");
			originaluserInputMake = scnr.nextLine();
			
			System.out.println("model: ");
			originaluserInputModel = scnr.nextLine();
			
			System.out.println("Color: ");	
			originaluserInputColor = scnr.nextLine();                //prompts user for user input of vehicle parameters
	
			System.out.println("Year: ");	
			originaluserInputYear = scnr.nextLine();
			
			System.out.println("Mileage: ");	
			originaluserInputMileage = scnr.nextLine();
			
			for(i = vehicleInventory.size() - 1; i >= 0 ; i--) {
			
				String currVehicleMake = getAutoMake(vehicleInventory, i);
				String currVehicleModel = getAutoModel(vehicleInventory, i);                        // declares and assigns string variables to each current vehicle parameter
				String currVehicleColor = getAutoColor(vehicleInventory, i);
				String currVehicleYear = getAutoYear(vehicleInventory, i);
				String currVehicleMileage = getAutoMileage(vehicleInventory, i);

				if(originaluserInputMake.equalsIgnoreCase(currVehicleMake) 
					&& originaluserInputModel.equalsIgnoreCase(currVehicleModel)
					&& originaluserInputColor.equalsIgnoreCase(currVehicleColor)               //checks to see if userinputted vehicle parameters match any vehicle in inventory
					&& originaluserInputYear.equalsIgnoreCase(currVehicleYear)
					&& originaluserInputMileage.equalsIgnoreCase(currVehicleMileage)) {
					
					return i;
				}
			}
		
		
		}catch(Exception e) {
			System.out.println("Failure");
				e.printStackTrace();
			}	
		return -1;	
	}
				
				
				
	

	
	
	
	public static void updateVehicle(Scanner scnr, ArrayList<Vehicle>vehicleInventory) { //method for updating vehicle
		try {
			int originalVehicleIndex = 	Vehicle.findOriginalVehicleInArrayList(scnr, vehicleInventory);    //declares and assigns int variable to findorginalvehicle method
		
			String newuserInputMake = "none";
			String newuserInputModel= "none";
			String newuserInputColor= "none";
			String newuserInputYear = "none";
			String newuserInputMileage= "none";
		
					
			System.out.println("Enter updated vehicle information: ");
		
			System.out.println("make: ");
			newuserInputMake = scnr.nextLine();
			
			System.out.println("model: ");
			newuserInputModel = scnr.nextLine();
			
			System.out.println("Color: ");	
			newuserInputColor = scnr.nextLine();
		
			System.out.println("Year: ");	
			newuserInputYear = scnr.nextLine();
			
			System.out.println("Mileage: ");	
			newuserInputMileage = scnr.nextLine();
		
			vehicleInventory.get(originalVehicleIndex).setAutoMake(newuserInputMake);
			vehicleInventory.get(originalVehicleIndex).setAutoModel(newuserInputModel);
			vehicleInventory.get(originalVehicleIndex).setAutoColor(newuserInputColor);    //sets current vehicle object's parameters to each new userinputted parameter
			vehicleInventory.get(originalVehicleIndex).setAutoYear(newuserInputYear);
			vehicleInventory.get(originalVehicleIndex).setAutoMileage(newuserInputMileage);
		
			System.out.println("New vehicle information: ");
			System.out.println("");
			System.out.println("Make: " + getAutoMake(vehicleInventory, originalVehicleIndex));
			System.out.println("");
			System.out.println("Model: " +  getAutoModel(vehicleInventory, originalVehicleIndex));
			System.out.println("");
			System.out.println("Color: " + getAutoColor(vehicleInventory, originalVehicleIndex));	
			System.out.println("");
			System.out.println("Year: " + getAutoYear(vehicleInventory, originalVehicleIndex));
			System.out.println("");
			System.out.println("Mileage: " + getAutoMileage(vehicleInventory, originalVehicleIndex));
	
		}catch(Exception e) {
			System.out.println("failure");
		e.printStackTrace();
		}
	}
}
