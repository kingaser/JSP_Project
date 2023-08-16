package service;

import java.util.List;

import entity.Reply;

public interface ReplyService {
	void addReply(Reply reply);

	void delReply(int replyId);

	List<Reply> getReplies();
}
