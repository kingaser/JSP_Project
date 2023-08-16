package dao;

import java.util.List;

import entity.Member;

public interface MemberDao {
	void insert(Member m);

	Member getbyUsername(String username, String passwd);

	Member getbyUsername_mem(String username);

	void delete(String username);

	List<Member> selectAll();
}
