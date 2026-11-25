package model;



public class Account {
private long accountNo;
private String name;
private String address;
private String adharNo;
private String panNo;
private long mobileNo;
private String email;
private double balance;
 public long getAccountNo() {
	 return accountNo;
 }
 public void setAccountNo(int accountNo) {
	 this.accountNo = (long)(Math.random()*Math.pow(10,10));
	 }
 public String getName() {
	 return name;
 }
 public void setName(String name) {
	 this.name=name;
 }
 
 public String getAddress() {
	 return address;
 }
 public void setAddress(String address) {
	 this.address=address;
 }
 
 public String getAdharNo() {
	 return adharNo;
 }
 public void setAdharNo(String adharNo) {
	 this.adharNo=adharNo;
 }
 
 public String getPanNo() {
	 return panNo;
 }
 public void setPanNo(String panNo) {
	 this.panNo=panNo;
 }
 
 public long getMobileNo() {
	 return mobileNo;
 }
 public void setMobileNo(long mobileNo) {
	 this.mobileNo=mobileNo;
 }
 
 public String getEmail() {
	 return email;
 }
 public void setEmail(String email) {
	 this.email=email;
}
 public double getBalance() {
	return balance;
 }
 public void setBalance(double balance) {
	this.balance = balance;
 }
 @Override
 public String toString() {
	return "Account [accountNo=" + accountNo + ", name=" + name + ", address=" + address + ", adharNo=" + adharNo
			+ ", panNo=" + panNo + ", mobileNo=" + mobileNo + ", email=" + email + ", balance=" + balance + "]";
 }
 
 
}