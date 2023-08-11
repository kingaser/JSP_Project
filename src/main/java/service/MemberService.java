package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import entity.Member;

public class MemberService {
	// 회원 목록
	public List<Member> selectAll() {
		List<Member> list = null;
		String sql = "select * from member order by username desc";
		try {
			String url = "jdbc:oracle:thin:@localhost:1521/orcl";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "sys", "1");
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String address = rs.getString("address");
				String phoneNumber = rs.getString("phoneNumber");
				String role = rs.getString("role");

				Member m = new Member(username, password, address, phoneNumber, role);
				list.add(m);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// 회원 등록
	public int register(Member m) {
		int result = 0;
		String sql = "insert into member(memberId, username, password, address, phoneNumber, role) values(memberId.nextval,?,?,?,?,'USER')";
		try {
			String url = "jdbc:oracle:thin:@localhost:1521/orcl";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "sys", "1");
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getUsername());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getAddress());
			pstmt.setString(4, m.getPhoneNumber());

			result = pstmt.executeUpdate();

			pstmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// 회원정보 수정
	public int upate(Member m) {
		int result = 0;
		String sql = "update member set password=? where username=?";
		try {
			String url = "jdbc:oracle:thin:@localhost:1521/orcl";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "sys", "1");
			PreparedStatement pstmt = con.prepareStatement(sql);
			result = pstmt.executeUpdate();

			pstmt.setString(1, m.getPassword());
			pstmt.setString(2, m.getUsername());

			pstmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// 회원정보 삭제
	public int delete(String username, String password) {
		int result = 0;
		String sql = "delete member where id=? and password=?";
		try {
			String url = "jdbc:oracle:thin:@localhost:1521/orcl";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "sys", "1");
			PreparedStatement pstmt = con.prepareStatement(sql);
			result = pstmt.executeUpdate();

			pstmt.setString(1, username);
			pstmt.setString(2, password);

			pstmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public Member login(Member m) {
		// TODO Auto-generated method stub
		Member login = null;
		String sql = "select * from member where username=? and password=?";
		try {
			String url = "jdbc:oracle:thin:@localhost:1521/orcl";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "sys", "1");
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getUsername());
			pstmt.setString(2, m.getPassword());
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				login.setUsername(rs.getString("username"));
				login.setPassword(rs.getString("password"));
				login.setAddress(rs.getString("address"));
				login.setPhoneNumber(rs.getString("phoneNumber"));
				login.setRole(rs.getString("role"));
				login.setMemberId(rs.getInt("memberId"));
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return login;
	}
}
