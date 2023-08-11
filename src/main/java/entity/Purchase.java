package entity;

public class Purchase {

	private int purchaseId;
	private int p_memberId;
	private String title;
	private int price;
	private int quantity;

	public Purchase(int p_memberId, String title, int price, int quantity) {
		super();
		this.p_memberId = p_memberId;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}

	public Purchase() {
		// TODO Auto-generated constructor stub
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
