package service;

import java.util.List;

import dao.ReplyDao;
import dao.ReplyDaoImpl;
import entity.Reply;

public class ReplyServiceImpl implements ReplyService {
	ReplyDao replyDao;

	public ReplyServiceImpl() {
		// TODO Auto-generated constructor stub
		replyDao = new ReplyDaoImpl();
	}

	@Override
	public void addReply(Reply reply) {
		// TODO Auto-generated method stub
		replyDao.register(reply);
	}

	@Override
	public void delReply(String username) {
		// TODO Auto-generated method stub
		replyDao.delete(username);
	}

	@Override
	public List<Reply> getReplies() {
		// TODO Auto-generated method stub
		return replyDao.selectAll();
	}

}
