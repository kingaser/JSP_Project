package entity;

public class Basket {

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

	public Basket() {
		// TODO Auto-generated constructor stub
	}

	public int getBasketId() {
		return basketId;
	}

	public void setBasketId(int basketId) {
		this.basketId = basketId;
	}

	public int getB_productId() {
		return b_productId;
	}

	public void setB_productId(int b_productId) {
		this.b_productId = b_productId;
	}

	public int getB_memberId() {
		return b_memberId;
	}

	public void setB_memberId(int b_memberId) {
		this.b_memberId = b_memberId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

}
