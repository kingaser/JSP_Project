package service;

import java.util.List;

import dao.MemberDao;
import dao.MemberDaoImpl;
import entity.Member;

public class MemberServiceImpl implements MemberService {
	MemberDao memberDao = null;

	public MemberServiceImpl() {
		// TODO Auto-generated constructor stub
		memberDao = new MemberDaoImpl();
	}

	@Override
	public void signup(Member m) {
		// TODO Auto-generated method stub

		memberDao.insert(m);
	}

	@Override
	public Member login(String username, String passwd) {
		// TODO Auto-generated method stub
		return memberDao.getbyUsername(username, passwd);
	}

	@Override
	public void deleteMember(String username) {
		// TODO Auto-generated method stub
		memberDao.delete(username);
	}

	@Override
	public Member getMemberByUsername(String username) {
		// TODO Auto-generated method stub
		return memberDao.getbyUsername_mem(username);
	}

	@Override
	public List<Member> getMembers() {
		// TODO Auto-generated method stub
		return memberDao.selectAll();
	}

}
