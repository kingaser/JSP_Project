package entity;

<<<<<<< HEAD
import java.io.File;

=======
>>>>>>> 27274548fbcbcd35f4ec9c1ae6a62d595cc0c362
public class Product {

	private int productId;
	private String title;
	private String author;
<<<<<<< HEAD
	private String productcontent;
	private String price;
	private String quantity;
	private String image;

=======
	private int price;
	private int quantity;
	private String image;

	public Product(String title, String author, int price, int quantity, String image) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
	}

>>>>>>> 27274548fbcbcd35f4ec9c1ae6a62d595cc0c362
	public Product() {
		// TODO Auto-generated constructor stub
	}

<<<<<<< HEAD
	public Product(String title, String author, String productcontent, String price, String quantity, String image) {
		super();
		this.title = title;
		this.author = author;
		this.productcontent = productcontent;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
	}

	public Product(int productId, String title, String author, String productcontent, String price, String quantity,
			String image) {
		super();
		this.productId = productId;
		this.title = title;
		this.author = author;
		this.productcontent = productcontent;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
	}

=======
>>>>>>> 27274548fbcbcd35f4ec9c1ae6a62d595cc0c362
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

<<<<<<< HEAD
	public String getProductcontent() {
		return productcontent;
	}

	public void setProductcontent(String productcontent) {
		this.productcontent = productcontent;
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
>>>>>>> 27274548fbcbcd35f4ec9c1ae6a62d595cc0c362
		this.quantity = quantity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
