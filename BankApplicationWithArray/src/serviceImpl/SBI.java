package serviceImpl;
import java.util.Scanner;
import model.Account;
import model.Constant;
import model.Validator;
import service.RBI;

	public class SBI implements RBI {

	    Account[] accounts = new Account[Constant.max_Size];

	    Scanner sc = new Scanner(System.in);

	    
	    @Override
	    public void createAccount() {

	        System.out.println("Enter no of accounts you want to create: ");

	        int num = sc.nextInt();      

	        for (int i = 0; i < num; i++) {

	            Account ac = new Account();

	            System.out.println("Your Account Number is: ");
	            ac.setAccountNo();
	            System.out.println(ac.getAccountNo());
	            
	           //System.out.println("Enter Name: ");
	            //ac.setName(sc.next());
	            Validator.validName();
	          //System.out.println("Enter Address: ");
	          //ac.setAddress(sc.next());
	            Validator.valiAddr();
	          
	            //System.out.println("Enter Mobile No.: ");
	           //ac.setMobileNo(sc.nextInt());
	          Validator.validNumber();
	            //System.out.println("Enter Adhar No.: ");
	            //ac.setAdharNo(sc.next());
	          Validator.validAdharNo();

	           //System.out.println("Enter Pan No.: ");
	            //ac.setPanNo(sc.next());
	          Validator.validPanNo();
	            
	            //System.out.println("Enter Email: ");
	            //ac.setEmail(sc.next());
	          Validator.validEmail();
	          
	            //System.out.println("Enter Balance: ");
	           //ac.setBalance(sc.nextDouble());
	            //accounts[i] = ac;
	          Validator.validBalance();
	          
	           
	            System.out.println("Account Created Successfully!!!");
	        }
	    }


	    @Override
	    public void displayAccountDetails() {
	    	System.out.println("Enter Account No: ");
	        long acNo = sc.nextLong();
	        
	        for (int i = 0; i < accounts.length; i++) {
	            if (accounts[i] != null && accounts[i].getAccountNo() == acNo) {
	                System.out.println(accounts[i]);
	               
	            }
	        }
	    }


	    @Override
	    public void displayAccountBalance() {
	        System.out.println("Enter Account No: ");
	        int acNo = sc.nextInt();
	        
	        for (Account ac : accounts) {
	            if (ac != null && ac.getAccountNo() == acNo) {
	                System.out.println("Your balance is: " + ac.getBalance());
	                return;
	            }  
	        }
	            
	        System.out.println("Invalid account no.");
	            
	            }




	    @Override
	    public void depositAmount() {
	        System.out.println("Enter Account No: ");
	        long acNo = sc.nextLong();
	        for (int i = 0; i < accounts.length; i++) {
	            if (accounts[i] != null &&
	                   accounts[i].getAccountNo() == acNo) {
	                System.out.println("Enter Amount to deposit: ");
	                double amount = sc.nextDouble();
	                if (amount <= 0) {
	                    System.out.println("Plz enter valid amount.");
	                } else {
	                    accounts[i].setBalance(
	                            accounts[i].getBalance() + amount);
	                    System.out.println(
	                            "Amount Deposited successfully!!");
	                    System.out.println(
	                            "Updated Balance: "
	                            + accounts[i].getBalance());
	                }
	                break;
	            }
	        }
	    }


	    @Override
	    public void withdrawAmount() {
	    	System.out.println("Enter Account No: ");
	        long acNo = sc.nextLong();
	        for (int i = 0; i < accounts.length; i++) {
	            if (accounts[i] != null &&
	                    accounts[i].getAccountNo() == acNo) {
	                System.out.println("Enter Amount to Withdraw: ");
	                double amount = sc.nextDouble();
	                if (amount <= 0) {
	                    System.out.println("Plz enter valid amount.");
	                } else if (amount <= accounts[i].getBalance()) {
	                    accounts[i].setBalance(
	                            accounts[i].getBalance() - amount);
	                    System.out.println("Withdrawal Successful.");
	                    System.out.println(
	                            "Remaining Balance: ₹"
	                            + accounts[i].getBalance());
	                } else {
	                    System.out.println("Insufficient Balance.");
	                }
	                break;
	            }
	        }
	    }

	    @Override
	    public void updateAccountDetails() {

	        System.out.println("Enter Account No: ");

	        long acNo = sc.nextLong();

	        for (int i = 0; i < accounts.length; i++) {

	            if (accounts[i] != null &&
	                    accounts[i].getAccountNo() == acNo) {

	                System.out.println("Enter New Name: ");
	                accounts[i].setName(sc.next());

	                System.out.println("Enter New Address: ");
	                accounts[i].setAddress(sc.next());

	                System.out.println("Enter New Mobile No.: ");
	                accounts[i].setMobileNo(sc.nextInt());

	                System.out.println(
	                        "Account Details Updated Successfully.");

	                break;
	            }
	        }
	    }
	}

