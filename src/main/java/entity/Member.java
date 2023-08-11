package entity;

public class Member {

	private int memberId;
	private String username;
	private String password;
	private String address;
	private String phoneNumber;
	private String role;

	public Member(String username, String password, String address, String phoneNumber, String role) {
		// TODO Auto-generated constructor stub
		username = this.username;
		password = this.password;
		address = this.address;
		phoneNumber = this.phoneNumber;
		role = this.role;
	}

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
