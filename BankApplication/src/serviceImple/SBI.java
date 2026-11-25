package serviceImple;                                                                                                                                                                     
import java.util.Scanner;

import model.Account;
import service.RBI;


public class SBI implements RBI {
	Scanner sc=new Scanner(System.in);
	Account ac=new Account();

	@Override
	public void createAccount() {
		System.out.println("Enter Account Number: ");
		int acNo=sc.nextInt();
		ac.setAccountNo(acNo);
		System.out.println("Enter Name: ");
		ac.setName(sc.next());
		System.out.println("Enter Address: ");
		ac.setAddress(sc.next());
		System.out.println("Enter Mobile No.: ");
		ac.setMobileNo(sc.nextLong());
		System.out.println("Enter Adhar No.: ");
		ac.setAdharNo(sc.next());
		System.out.println("Enter Pan No.: ");
		ac.setPanNo(sc.next());
		System.out.println("Enter Email: ");
		ac.setEmail(sc.next());
		System.out.println("Enter Balance: ");
		ac.setBalance(sc.nextDouble());
		
		
		
		System.out.println("Account Created Successfully!!!");
		
		
		
	}

	@Override
	public void displayAccountDetails() {
		System.out.println("Enter Account No: ");
		int acNo = sc.nextInt();
		if(acNo == ac.getAccountNo()) {
			System.out.println(ac);
		} else
		{
			System.out.println("Invalid Account No. Plz Try again..");
		}
		
	}

	@Override
	public void displayAccountBalance() {
		System.out.println("Enter Account No: ");
		int acNo = sc.nextInt();
		if(acNo == ac.getAccountNo()) {
			System.out.println("Your balance is: "+ac.getBalance());
		} else
		{
			System.out.println("Invalid Account No. Plz Try again..");
		
		
	}
	}

	@Override
	public void depositAmount() {
		System.out.println("Enter Account No: ");
		int acNo = sc.nextInt();
		
		if(acNo == ac.getAccountNo()) {
			System.out.println("Enter Amount to deposite: ");
		
		    double amount = sc.nextDouble();
		    
		    if(amount <= 0) {
	        	System.out.println("Enter valid amount");
	        }
		    ac.setBalance(ac.getBalance() + amount);
		    System.out.println("Amount Deposited successfully!!");
		    System.out.println("Updated Balance: "+ac.getBalance());
		
		} 
		else {
			System.out.println("Invalid Account No. Plz Try again..");
		}
		
		
	}

	@Override
	public void updateAccountDetails() {
		System.out.println("Enter Account No: ");
        int acNo = sc.nextInt();

        if (acNo == ac.getAccountNo()) {

            System.out.println("Enter New Name: ");
            ac.setName(sc.next());

            System.out.println("Enter New Address: ");
            ac.setAddress(sc.next());

            System.out.println("Enter New Mobile No.: ");
            ac.setMobileNo(sc.nextLong());

            System.out.println("Account Details Updated Successfully.");

        } else {
            System.out.println("Invalid Account No.");
        }
		
	}

	@Override
	public void withdrawAmount() {
		 System.out.println("Enter Account No: ");
	        int acNo = sc.nextInt();

	        if (acNo == ac.getAccountNo()) {

	            System.out.println("Enter Amount to Withdraw: ");
	            double amount = sc.nextDouble();
                if(amount <= 0) {
                	System.out.println("Enter valid amount");
                }
	            else if (amount <= ac.getBalance()) {

	                ac.setBalance(ac.getBalance() - amount);

	                System.out.println("Withdrawal Successful.");
	                System.out.println("Remaining Balance: ₹" + ac.getBalance());

	            } else {
	                System.out.println("Insufficient Balance.");
	            }

	        } else {
	            System.out.println("Invalid Account No.");
	        }
		
	}

}