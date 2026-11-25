
package Online_Food_Order_System;

import java.util.Scanner;

public class AdminController {
	
	public static void main(String[] args) {
		FoodOrder fo=new FoodOrder();
		
		Scanner sc=new Scanner(System.in);
		
		
		System.out.println("Enter Amount : ");
		double amount=sc.nextDouble();
		
		System.out.println("Enter PaymentStatus : ");
		String payment=sc.next();
		
		System.out.println("Enter Distance : ");
		int distance =sc.nextInt();
		
		fo.setAmount(amount);
		fo.setPaymentStatus(payment);
        fo.setDistance(distance);		
        
        fo.runOrderSystem();
		
	}
	

}

