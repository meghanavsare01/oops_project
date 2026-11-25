package controller;

import java.util.Scanner;

public class Login {

	Scanner sc=new Scanner(System.in);
	
	public void loginUser() {
		
		System.out.println("Login here ");
		if(Register.email==null || Register.password==null) {
			System.out.println("pls enter details ");
			return;
		}
		while(true) {
			System.out.println("Enter email id : ");
			String email=sc.next();
			System.out.println("Enter password : ");
			String password=sc.next();
			
			if(email.equals(Register.email)&& password.equals(Register.password)) {
				System.out.println("login successfully");
				break;
			}
			else {
				System.out.println("invalid details");
			}
		}
	}
}
