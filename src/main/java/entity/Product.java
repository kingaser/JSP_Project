package entity;

public class Product {

	private int productId;
	private String title;
	private String author;
	private String productContent;
	private int price;
	private int quantity;
	private String image;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String title, String author, int price, int quantity, String image) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
	}

	public Product(String title, String author, String productContent, int price, int quantity, String image) {
		this.title = title;
		this.author = author;
		this.productContent = productContent;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
	}

	public Product(int productId, String title, String author, String productContent, int price, int quantity,
				   String image) {
		super();
		this.productId = productId;
		this.title = title;
		this.author = author;
		this.productContent = productContent;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}