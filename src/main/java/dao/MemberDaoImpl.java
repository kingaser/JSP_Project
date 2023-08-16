package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Member;

public class MemberDaoImpl implements MemberDao {
	private Connection con = null;
	private PreparedStatement pstmt = null;

	@Override
	public List<Member> selectAll() {
		// TODO Auto-generated method stub
		List<Member> list = new ArrayList<Member>();
		String sql = "select * from member order by username asc";
		try {
			String url = "jdbc:oracle:thin:@localhost:1521/orcl";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "sys as sysdba", "1");
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Member getbyUsername(String username, String passwd) {
		// TODO Auto-generated method stub
		Member member = null;
		String sql = "select * from member where username=? and passwd=?";
		try {
			String url = "jdbc:oracle:thin:@localhost:1521/orcl";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "sys as sysdba", "1");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, passwd);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}

	@Override
	public Member getbyUsername_mem(String username) {
		// TODO Auto-generated method stub
		Member member = null;
		String sql = "select * from member where username=?";
		try {
			String url = "jdbc:oracle:thin:@localhost:1521/orcl";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "sys as sysdba", "1");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
			String url = "jdbc:oracle:thin:@localhost:1521/orcl";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "sys as sysdba", "1");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getUsername());
			pstmt.setString(2, m.getPasswd());
			pstmt.setString(3, m.getAddress());
			pstmt.setString(4, m.getTel());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String username) {
		// TODO Auto-generated method stub
		String sql = "delete member where username=?";
		try {
			String url = "jdbc:oracle:thin:@localhost:1521/orcl";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "sys as sysdba", "1");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
