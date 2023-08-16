package entity;

public class Member {

	private int memberId;
	private String username;
<<<<<<< HEAD
	private String passwd;
	private String address;
	private String tel;
	private String role;

=======
	private String password;
	private String address;
	private String phoneNumber;
	private String role;

	public Member(String username, String password, String address, String phoneNumber, String role) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.password = password;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.role = role;
	}

>>>>>>> 27274548fbcbcd35f4ec9c1ae6a62d595cc0c362
	public Member() {
		// TODO Auto-generated constructor stub
	}

<<<<<<< HEAD
	public Member(int memberId, String username, String passwd, String address, String tel, String role) {
		super();
		this.memberId = memberId;
		this.username = username;
		this.passwd = passwd;
		this.address = address;
		this.tel = tel;
		this.role = role;
	}

=======
>>>>>>> 27274548fbcbcd35f4ec9c1ae6a62d595cc0c362
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

<<<<<<< HEAD
	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
=======
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
>>>>>>> 27274548fbcbcd35f4ec9c1ae6a62d595cc0c362
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

<<<<<<< HEAD
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
=======
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
>>>>>>> 27274548fbcbcd35f4ec9c1ae6a62d595cc0c362
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
