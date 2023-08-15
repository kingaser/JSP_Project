package dao;

import java.util.List;

import entity.Reply;

public interface ReplyDao {
	void register(Reply reply);

	void delete(String username);

	List<Reply> selectAll();
}
