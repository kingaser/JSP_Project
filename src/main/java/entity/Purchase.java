package entity;

public class Purchase {
	private int memberId;
	private String username;
	private String passwd;
	private String address;
	private String tel;
	private String role;

	private int purchaseId;
	private int p_memberId;
	private String title;
	private String price;
	private String quantity;

	public Purchase() {
		// TODO Auto-generated constructor stub
	}

	public Purchase(int memberId, String username, String passwd, String address, String tel, String role,
			int purchaseId, int p_memberId, String title, String price, String quantity) {
		super();
		this.memberId = memberId;
		this.username = username;
		this.passwd = passwd;
		this.address = address;
		this.tel = tel;
		this.role = role;
		this.purchaseId = purchaseId;
		this.p_memberId = p_memberId;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
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
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public int getP_memberId() {
		return p_memberId;
	}

	public void setP_memberId(int p_memberId) {
		this.p_memberId = p_memberId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}
