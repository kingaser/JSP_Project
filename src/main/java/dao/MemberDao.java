package dao;

import java.util.List;

import entity.Member;

public interface MemberDao {
	void insert(Member m);

	Member getByUsername(String username, String passwd);

	Member getByUsername_mem(String username);

	void delete(String username);

	List<Member> selectAll();
}