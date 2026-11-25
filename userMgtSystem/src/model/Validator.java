

package model;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {
  static Scanner sc =new Scanner(System.in);
  
  
  public static int validUserId() {
	  while(true) {
		  System.out.println("Enter User ID: ");
		  int uId=sc.nextInt();
		  if(uId >= 0) {
			  return uId;
		  }else {
		  System.out.println("Enter valid user Id");
		  }
	  }
  }
  public static String validUserName() {
	  while(true) {
		  System.out.println("Enter name: ");
		  String name=sc.next();
		  if(Pattern.matches("[A-Za-z]+", name)) {
				return name;
			} else {
				System.out.println("Invalid name.. Plzz Enter again!");
			
			}
		}
  }
  
  public static int validAge() {
	  while(true) {
		  System.out.println("Enter Age: ");
		  int age=sc.nextInt();
		  if(age > 0 && age <= 125) {
			  return age;
		  }else {
		  System.out.println("Enter valid Age");
		  }
	  }
  }
  
  public  static String validAddress() {
		
		while(true) {
			System.out.println("Enter Address: ");
			String address=sc.next();
		if(Pattern.matches("[A-Za-z]+", address)) {
			return address;
		} else {
			System.out.println("Invalid address.. Plzz Enter again!");
		
		}
		}
	}
  
  public  static long validMobileNo() {
		
		while(true) {
			System.out.println("Enter Mobile Number: ");
			long mobile=sc.nextLong();
		if(mobile <= 9999999999l && mobile >= 6000000000l) {
			return mobile;
		} else {
			System.out.println("Invalid mobile no.. Plzz Enter again!");
		
		}
		}
	}
  
  public  static String validAdharNo() {
		
		while(true) {
			System.out.println("Enter Adhar Number: ");
			String adhar=sc.next();
		if(Pattern.matches("[2-9]{1}[0-9]{3}[0-9]{4}[0-9]{4}+", adhar)) {
			return adhar;
		} else {
			System.out.println("Invalid Adhar number.. Plzz Enter again!");
		
		}
		}
	}
	
	
public  static String validPanNo() {
		
		while(true) {
			System.out.println("Enter PanNo: ");
			String name=sc.next();
		if(Pattern.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}+", name)) {
			return name;
		} else {
			System.out.println("Invalid PanNo.. Plzz Enter again!");
		
		}
		}
	}



public  static String validEmail() {
	
	while(true) {
		System.out.println("Enter email: ");
		String email=sc.next();
	if(Pattern.matches("^[A-Za-z0-9]+@[A-Za-z]+.com", email)) {
		return email;
	} else {
		System.out.println("Invalid email.. Plzz Enter again!");
	
	}
	}
}

public  static String validPassword() {
	
	while(true) {
		System.out.println("Enter Password: ");
		String password=sc.next();
	if(Pattern.matches("^[A-Z]{1}[a-z0-9]+", password)) {
		return password;
	} else {
		System.out.println("Invalid Password.. Plzz Enter again!");
	
	}
	}
}


  
  
}
