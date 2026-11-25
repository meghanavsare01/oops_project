package serviceImple;

import java.util.Scanner;

import model.User;
import model.Validator;
import service.userService;

public class userServiceimple implements userService {
	
	Scanner sc=new Scanner(System.in);
	User user=new User();

	@Override
	public void createUser() {
	/**System.out.println("Enter user id : ");
	long uid=sc.nextLong();
	user.setUid(uid);
	System.out.println("Enter user name : ");
	String uname=sc.next();
	System.out.println("Enter user address : ");
	String address=sc.next();
	System.out.println("ENter mobile Number : ");
	Long mobileNo=sc.nextLong();
	System.out.println("Enter Pan Number : ");
	String panNo=sc.next();
	System.out.println("Enter email id : ");
	String email=sc.next(); **/
		
		user.setUid(Validator.validUserId());
		user.setUname(Validator.validUserName());
		user.setAddress(Validator.validAddress());
		user.setMobileNo(Validator.validMobileNo());
		user.setPanNo(Validator.validPanNo());
		user.setEmail(Validator.validEmail());

	
	System.out.println("User added");
		
	}

	@Override
	public void displayUserDetails() {
		System.out.println("Enter user id : ");
		long userid=sc.nextLong();
		if(userid==user.getUid()) {
			System.out.println(user);
		}
		else {
			System.out.println("Invalid user id ");
		}
		
		
	}

	@Override
	
		public void updateUserDetails() {
			System.out.println("Enter User ID: ");
	        int uid = sc.nextInt();

	        if (uid == user.getUid()) {

	            System.out.println("Enter New Name: ");
	            user.setUname(sc.next());

	            System.out.println("Enter New Address: ");
	            user.setAddress(sc.next());

	            System.out.println("Enter New Mobile No.: ");
	            user.setMobileNo(sc.nextLong());

	            System.out.println("User Details Updated Successfully.");

	        } else {
	            System.out.println("Invalid Account No.");
	        }
			
		}
		
	

	@Override
	public void deleteUserInfo() {
		
			System.out.println("Enter User ID: ");
	        int uid = sc.nextInt();

	        if (user != null && uid == user.getUid()) {

	            user = null;

	            System.out.println("User deleted successfully!");

	        } else {
	            System.out.println("Invalid User ID.");
	        }
			
		

	}
		
	}

	


