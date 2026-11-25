package ParkingLotMgtSystem;

import java.util.Scanner;

public class ParkingLot {
	Scanner sc=new Scanner(System.in);
	private vehicle[] parkingSpaces;
	private int count=0;
	
	public ParkingLot() {
		parkingSpaces= new vehicle[constant.MAX_PARKING_SPACES];
	}
	

	public vehicle[] getParkingSpaces() {
		return parkingSpaces;
	}

	public void setParkingSpaces(vehicle[] parkingSpaces) {
		this.parkingSpaces = parkingSpaces;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
    public void addVehicle() {
    	if(count<constant.MAX_PARKING_SPACES) {
    		
    		vehicle v=new vehicle();
    		System.out.println("Enter vehicle number");
    		v.setVehicleNumber(sc.next());
    		System.out.println("Enter owner name");
    		v.setOwnerName(sc.next());
    		System.out.println("Enter vehicle type ");
    		v.setVehicleType(sc.next());
    		
    		
    		parkingSpaces[count]= v;
    		count++;
    		System.out.println("Vehicle added successfully ....");
    		
    	}
    	
		
	}

	public void displayVehicle() {
		 if (count == 0) {
		        System.out.println("Parking is empty");
		        return;
		    }

		    for (vehicle v : parkingSpaces) {

		        if (v != null) {
		            System.out.println(
		                v.getVehicleNumber() + " " +
		                v.getOwnerName() + " " +
		                v.getVehicleType()
		            );
		        }
		    }
		
		
	}
	
	public void searchVehicle(String vehicleNumber) {
		 boolean vehiclePresent = false;

		    if (count == 0) {
		        System.out.println("Parking is empty");
		        return;
		    }

		    for (vehicle v : parkingSpaces) {

		        if (v != null) {

		            if (v.getVehicleNumber().equals(vehicleNumber)) {

		                vehiclePresent = true;

		                System.out.println(
		                    v.getVehicleNumber() + " " +
		                    v.getOwnerName() + " " +
		                    v.getVehicleType()
		                );
		            }
		        }
		    }

		    if (!vehiclePresent) {
		        System.out.println("Vehicle not found");
		    }
		
		
	
	}
	
	public void countVehicleByType() {
		   int carCount = 0;
		    int bikeCount = 0;
		    int autoCount = 0;

		    for (vehicle v : parkingSpaces) {

		        if (v != null) {

		            switch (v.getVehicleType().toLowerCase()) {

		                case "car":
		                    carCount++;
		                    break;

		                case "bike":
		                    bikeCount++;
		                    break;

		                case "auto":
		                    autoCount++;
		                    break;

		                default:
		                    System.out.println("Unknown vehicle type: "
		                            + v.getVehicleType());
		            }
		        }
		    }

		    System.out.println("Cars: " + carCount);
		    System.out.println("Bikes: " + bikeCount);
		    System.out.println("Auto: " + autoCount);
		
	}
}
