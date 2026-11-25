package ParkingLotMgtSystem;

import java.util.Scanner;

public class InputHandler {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		ParkingLot parkinglot=new ParkingLot();
		
		boolean flag=true;
		while(flag) {
			
			System.out.println("----Parking lot Management System----");
			System.out.println("1.Add vehicle ");
			System.out.println("2.Display All vehicles ");
			System.out.println("3.Search Vheicle by Number ");
			System.out.println("4.Count vehicles by Type ");
			
			int type=sc.nextInt();
			switch(type){
			case 1:
				parkinglot.addVehicle();
				break;
				
			case 2:
				parkinglot.displayVehicle();
				break;
				
			case 3:
				System.out.println("Enter vehicle number to search:");
			    String vehicleNumber = sc.next();
				parkinglot.searchVehicle(vehicleNumber);
				break;
				
			case 4:
				parkinglot.countVehicleByType();
				break;
				
			case 5:
				flag=false;
				System.out.println("Aplication Exit.... Thank You for Visisting!");
				break;
			default:
				System.out.println("Invalid choice.... Choose again");
				break;
			}
		}
	}

}
