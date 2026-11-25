package model;

public class User {
	private long uid;
	private String uname;
	private String address;
	private long mobileNo;
	private String panNo;
	private String email;
	
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		//this.uid = (long)(Math.random()*Math.pow(10,10));
		this.uid=uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", address=" + address + ", mobileNo=" + mobileNo + ", panNo="
				+ panNo + ", email=" + email + "]";
	}
	

}
