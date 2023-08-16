package entity;

public class Reply {

	private int memberId;
	private String username;
	private String passwd;
	private String address;
	private String tel;
	private String role;
	private int replyId;
	private int r_productId;
	private int r_memberId;
	private String replyContent;
	private int productId;
	private String title;
	private String author;
	private String productContent;
	private String price;
	private String quantity;
	private String image;
	private String content;

	public Reply() {
		// TODO Auto-generated constructor stub
	}

	public Reply(int r_productId, int r_memberId, String content) {
		this.r_productId = r_productId;
		this.r_memberId = r_memberId;
		this.content = content;
	}

	public Reply(int memberId, String username, String passwd, String address, String tel, String role, int replyId,
				 int r_productId, int r_memberId, String replyContent, int productId, String title, String author,
				 String productContent, String price, String quantity, String image) {
		this.memberId = memberId;
		this.username = username;
		this.passwd = passwd;
		this.address = address;
		this.tel = tel;
		this.role = role;
		this.replyId = replyId;
		this.r_productId = r_productId;
		this.r_memberId = r_memberId;
		this.replyContent = replyContent;
		this.productId = productId;
		this.title = title;
		this.author = author;
		this.productContent = productContent;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
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

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public int getR_productId() {
		return r_productId;
	}

	public void setR_productId(int r_productId) {
		this.r_productId = r_productId;
	}

	public int getR_memberId() {
		return r_memberId;
	}

	public void setR_memberId(int r_memberId) {
		this.r_memberId = r_memberId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getProductContent() {
		return productContent;
	}

	public void setProductContent(String productContent) {
		this.productContent = productContent;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}