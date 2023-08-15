package entity;

public class Member {

	private int memberId;
	private String username;
	private String passwd;
	private String address;
	private String phoneNumber;
	private String role;

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(int memberId, String username, String passwd, String address, String phoneNumber, String role) {
		super();
		this.memberId = memberId;
		this.username = username;
		this.passwd = passwd;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.role = role;
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

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return phoneNumber;
	}

	public void setTel(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
