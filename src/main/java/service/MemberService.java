package service;

import entity.Member;

import java.util.List;

public interface MemberService {
	void signup(Member m);

	Member login(String username, String passwd);

	void deleteMember(String username);

	Member getMemberById(int id);

	List<Member> getMembers();

	Member getMemberByUsername(String sessionUsername);
}
