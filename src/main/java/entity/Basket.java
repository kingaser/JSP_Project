package entity;

public class Basket {

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
    private int price;
    private int quantity;
    private String image;


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

    public Basket(int basketId, int b_memberId, int b_productId) {
        this.basketId = basketId;
        this.b_memberId = b_memberId;
        this.b_productId = b_productId;
    }

    public Basket(int memberId, String username, String passwd, String address, String tel, String role, int basketId,
                  int b_memberId, int b_productId, int productId, String title, String author, String content, int price,
                  int quantity, String image) {
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

    public int getBasketId() {
        return basketId;
    }

    public void setBasketId(int basketId) {
        this.basketId = basketId;
    }

    public int getB_memberId() {
        return b_memberId;
    }

    public void setB_memberId(int b_memberId) {
        this.b_memberId = b_memberId;
    }

    public int getB_productId() {
        return b_productId;
    }

    public void setB_productId(int b_productId) {
        this.b_productId = b_productId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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