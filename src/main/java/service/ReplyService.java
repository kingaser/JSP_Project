package service;

import java.util.List;

import entity.Reply;

public interface ReplyService {
	void addReply(Reply reply);

	void delReply(String username);

	List<Reply> getReplies();
}
