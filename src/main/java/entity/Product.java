package entity;

public class Product {

	private int productId;
	private String title;
	private String author;
	private String price;
	private String quantity;
	private String image;
	private String content;

	public Product(String title, String author, String price, String quantity, String image) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
	}

	public Product(int productId, String title, String author, String price, String quantity, String image, String content) {
		this.productId = productId;
		this.title = title;
		this.author = author;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
		this.content = content;
	}

	public Product(int productId, String title, String author, String price, String quantity,
				   String image) {
		this.productId = productId;
		this.title = title;
		this.author = author;
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