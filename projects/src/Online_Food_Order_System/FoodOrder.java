package Online_Food_Order_System;

import java.util.Scanner;

public class FoodOrder {

	double amount;
	String paymentStatus;
	int distance;
	
	public void setAmount(double amount) {
		this.amount=amount;
	}
	
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus=paymentStatus;
	}
	
	public void setDistance(int distance ) {
		this.distance=distance;
	}
	
	public void checkOrderType() {
		if (amount>=100) {
			System.out.println("Premium order");
		}
		else if(amount>=500) {
			System.out.println("Standard order");
		}
		else {
			System.out.println("Basic order");
		}
	}
	 
	// If amount is **>= 800** → Print **"Free Delivery"**
//	* If amount is **>= 300** → Print **"Delivery Charge: 50"**
	//* Otherwise → Print **"Delivery Charge: 100"**
	
	public void checkDeliveryCharge() {
		if (amount>=800) {
			System.out.println("Free Delivery");
		}
		else if (amount >=300) {
			System.out.println("Delivery Charge : 50 ");
		}
		else {
			System.out.println("Delivery Charge : 100 ");
		}
		
	}
	
	public void checkPaymentStatus() {
		if(paymentStatus=="paid") {
			System.out.println("Order is confirmed");
			
		}
		else {
			System.out.println("not confirmed");
		}
		
	}
	
	
	
	public void checkDeliveryTime() {
		if (distance <=3) {
			System.out.println("Delivery in 20 minutes");
		}
		else if (distance <=7) {
			System.out.println("Delivery in 40 minutes ");
		}
		else {
			System.out.println("Delivery in 60 minutes");
		}
	}
	
	public void checkDiscount() {
		if (amount>=1200) {
			System.out.println("Discount applied 20% ");
		}
		else if (amount >=800) {
			System.out.println("Discount applied 10%");
		}
		else {
			System.out.println("No discount");
		}
	} 
	
	public void  runOrderSystem() {
		Scanner sc=new Scanner(System.in);
		
		boolean flag=true;
		while(true) {
		
		System.out.println("1. Order type ");
		System.out.println("2. Delivery Charge  ");
		System.out.println("3. Payment Status ");
		System.out.println("4.Delivery Time ");
		System.out.println("5. Discount rate ");
		System.out.println("Enter your choice");
		
       int choice=sc.nextInt();
		
		switch(choice) {
		case 1:
			checkOrderType();
			break;
			
		case 2:
			checkDeliveryCharge();
			break;
			
		case 3:
			checkPaymentStatus();
			break;
			
		case 4:
			checkDeliveryTime();
			break;
			
		case 5:
			checkDiscount();
			break;
			
		
		case 6:
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
