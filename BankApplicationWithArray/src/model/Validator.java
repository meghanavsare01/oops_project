package model;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {
	 static Scanner sc=new Scanner(System.in);
	public static String validName() {
		while(true) {
			System.out.println("Enter name : ");
			String name= sc.next();
			if(Pattern.matches("[A-Z,a-z]+", name)) {
				return name;
				
			}else {
				System.out.println("Invalid name ");
			}
			
		}
		
	}
	
	public static String valiAddr() {
		while(true) {
			System.out.println("Enter address: ");
			String address= sc.next();
			if(Pattern.matches("[A-Z,a-z]+", address)) {
				return address;
				
			}else {
				System.out.println("Invalid address ");
			}
			
		}
		
	}
	
	
	
	
	public static String validPanNo() {
		while(true) {
		System.out.println("Enter pan number ");
		String panNo=sc.next();
		if(Pattern.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}+", panNo)){
			return panNo;	
		}else {
			System.out.println("ENter valid pan number");
		}
		
	}
	}
	
	public static String validAdharNo(){
		while(true) {
			System.out.println("Enter Adhar number ");
			String aadharNo=sc.next();
			if(Pattern.matches("[2-9]{1}[0-9]{3}[0-9]{4}[0-9]{4}+", aadharNo)){
				return aadharNo;	
			}else {
				System.out.println("ENter valid Adhar number");
			}
			
		}
	}
		
		public static long validNumber(){
			while(true) {
				System.out.println("Enter mobile number ");
			long mobileNo=sc.nextLong();
				if(mobileNo<=9999999999l && mobileNo >=6000000000l) {
					return mobileNo;	
				}else {
					System.out.println("ENter valid mobile number");
				}
				
			}
	}
		
		public static String validEmail() {
			while(true) {
			System.out.println("Enter email ");
			String email=sc.next();
			if(Pattern.matches("[A-Z][a-z][0-9]+@+[a-z]+.+[a-z]", email)){
				return email;	
			}else {
				System.out.println("ENter valid email");
			}
			
		}
		}
		
		public static double validBalance() {
			while(true) {
				System.out.println("Enter balance: ");
				double balance= sc.nextDouble();
				if(balance > 0) {
					return balance;
					
				}else {
					System.out.println("Invalid Number ");
				}
				
			}
			
		}
		
}
