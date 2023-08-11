package entity;

public class Reply {

	private int replyId;
	private int r_productId;
	private int r_memberId;
	private String content;

	public Reply(int r_productId, int r_memberId, String content) {
		super();
		this.r_productId = r_productId;
		this.r_memberId = r_memberId;
		this.content = content;
	}

	public Reply() {
		// TODO Auto-generated constructor stub
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
