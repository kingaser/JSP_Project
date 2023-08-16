package entity;

public class Basket {

<<<<<<< HEAD
	private int memberId;
	private String username;
	private String passwd;
	private String address;
	private String tel;
	private String role;

	private int basketId;
	private int b_memberId;
	private int b_productId;

	private int productId;
	private String title;
	private String author;
	private String content;
	private String price;
	private String quantity;
	private String image;

//	private String title;
//	private int price;
//	private int quantity;
=======
	private int basketId;
	private int b_productId;
	private int b_memberId;
	private String title;
	private int price;
	private int quantity;


	public Basket(int b_productId, int b_memberId, String title, int price, int quantity) {
		super();
		this.b_productId = b_productId;
		this.b_memberId = b_memberId;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}
>>>>>>> 27274548fbcbcd35f4ec9c1ae6a62d595cc0c362

	public Basket() {
		// TODO Auto-generated constructor stub
	}

<<<<<<< HEAD
	public Basket(int basketId, int b_memberId, int b_productId) {
		super();
		basketId = this.basketId;
		b_memberId = this.b_memberId;
		b_productId = this.b_productId;
//		this.title = title;
//		this.price = price;
//		this.quantity = quantity;
	}

	public Basket(int memberId, String username, String passwd, String address, String tel, String role, int basketId,
			int b_memberId, int b_productId, int productId, String title, String author, String content, String price,
			String quantity, String image) {
		super();
		this.memberId = memberId;
		this.username = username;
		this.passwd = passwd;
		this.address = address;
		this.tel = tel;
		this.role = role;
		this.basketId = basketId;
		this.b_memberId = b_memberId;
		this.b_productId = b_productId;
		this.productId = productId;
		this.title = title;
		this.author = author;
		this.content = content;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
	}

=======
>>>>>>> 27274548fbcbcd35f4ec9c1ae6a62d595cc0c362
	public int getBasketId() {
		return basketId;
	}

	public void setBasketId(int basketId) {
		this.basketId = basketId;
	}

<<<<<<< HEAD
	public int getB_memberId() {
		return b_memberId;
	}

	public void setB_memberId(int b_memberId) {
		this.b_memberId = b_memberId;
	}

=======
>>>>>>> 27274548fbcbcd35f4ec9c1ae6a62d595cc0c362
	public int getB_productId() {
		return b_productId;
	}

	public void setB_productId(int b_productId) {
		this.b_productId = b_productId;
	}

<<<<<<< HEAD
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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
=======
	public int getB_memberId() {
		return b_memberId;
	}

	public void setB_memberId(int b_memberId) {
		this.b_memberId = b_memberId;
>>>>>>> 27274548fbcbcd35f4ec9c1ae6a62d595cc0c362
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

<<<<<<< HEAD
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {zgd
//		this.title = title;
//	}
//
//	public int getPrice() {
//		return price;
//	}
//
//	public void setPrice(int price) {
//		this.price = price;
//	}
//
//	public int getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}

=======
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

>>>>>>> 27274548fbcbcd35f4ec9c1ae6a62d595cc0c362
}
