package controller;
import java.util.Scanner;

import service.RBI;
import serviceImple.SBI;

                                                                                                                                                                                                                            
public class AdminController {
public static void main(String args[]) {
	
	
	Scanner sc = new Scanner(System.in);
	
	RBI rbi = new SBI();
	System.out.println("---WELCOME TO SBI----");
	System.out.println("----------------------");
	
	
	boolean flag=true;
	while(flag) {
	System.out.println("1. Create Account");
	System.out.println("2. Display Account Details");
	System.out.println("3. Display Account Balance");
	System.out.println("4. Withdraw Amount");
	System.out.println("5. Deposit Amount");
	System.out.println("6. Update Account Details");
	System.out.println("7. Exit...!");
	
	System.out.println("-----------------------------");
	System.out.println("Enter Your Choice: ");
	int ch=sc.nextInt();
	
	switch(ch) {
	case 1:
		rbi.createAccount();
		
		break;
	case 2:
		rbi.displayAccountDetails();
		break;
	case 3:
		rbi.displayAccountBalance();
		break;
	case 4:
		rbi.withdrawAmount();
		break;
	case 5:
		rbi.depositAmount();
		break;	
	case 6:
		rbi.updateAccountDetails();
		break;
	case 7:
		flag=false;
		System.out.println("Aplication Exit.... Thank You for Visisting!");
		break;
	default:
		System.out.println("Invalid choice.... Choose again");
		break;
	}
	}
	sc.close();
}
}
