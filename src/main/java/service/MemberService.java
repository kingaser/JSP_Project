package service;

import java.util.List;

import entity.Member;

public interface MemberService {
	void signup(Member m);

	Member login(String username, String passwd);

	void deleteMember(String username);

	Member getMemberByUsername(String username);

	List<Member> getMembers();

}
