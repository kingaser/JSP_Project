package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Member;
import entity.Product;
import util.dbconn;

public class MemberDaoImpl implements MemberDao {
	dbconn db = null;
	Connection con = null;

	public MemberDaoImpl() {
		// TODO Auto-generated constructor stub
		db = new dbconn();
		con = db.getConnection();
	}

	@Override
	public List<Member> selectAll() {
		// TODO Auto-generated method stub
		List<Member> list = new ArrayList<Member>();
		String sql = "select * from member order by username asc";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6)));
			}

			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Member getByUsername(String username, String passwd) {
		// TODO Auto-generated method stub
		Member member = null;
		String sql = "select * from member where username=? and passwd=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, passwd);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
			}

			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}

	@Override
	public Member getByUsername_mem(String username) {
		// TODO Auto-generated method stub
		Member member = null;
		String sql = "select * from member where username=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
			}

			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}

	@Override
	public void insert(Member m) {
		// TODO Auto-generated method stub
		String sql = "insert into member values(memberId.nextval,?,?,?,?,'USER')";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getUsername());
			pstmt.setString(2, m.getPasswd());
			pstmt.setString(3, m.getAddress());
			pstmt.setString(4, m.getTel());

			pstmt.executeUpdate();

			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String username) {
		// TODO Auto-generated method stub
		String sql = "delete member where username=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.executeUpdate();

			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
