package controller;

import java.util.Scanner;

import model.Validator;

public class Register {
	 static Scanner sc=new Scanner(System.in);
	 static Validator v=new Validator();
	 
	 static String email;
	 static String password;
	 
	 
	 public static void registerUser() {
		 System.out.println("Register user details ");
		 email=Validator.validEmail();
		 
		 password=Validator.validPassword();
		 System.out.println("Registration compeleted ");
	 }

}
