package dao;

import entity.Basket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BasketDaoImpl implements BasketDao {
	private Connection con = null;
	private PreparedStatement pstmt = null;

	@Override
	public List<Basket> selectAll() {
		// TODO Auto-generated method stub
		List<Basket> list = new ArrayList<Basket>();
		String sql = "select * from (select * from member m left join basket b on m.memberId=b.b_memberId order by m.username asc) a left join product p on a.b_productId=p.productId order by a.username asc";

		try {
			String url = "jdbc:oracle:thin:@localhost:1521/orcl";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "JSP", "123123");
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Basket(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getString(11),
						rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16)));
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
	public Basket getByUsername(String username) {
		// TODO Auto-generated method stub
		Basket basket = null;
		String sql = "select * from (select * from member m left join basket b on m.memberId=b.b_memberId order by m.username asc) a left join product p on a.b_productId=p.productId where a.username=? order by a.username asc";
		try {
			String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "JSP", "123123");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				basket = new Basket(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getString(11),
						rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return basket;
	}

	@Override
	public void insert(Basket basket) {
		// TODO Auto-generated method stub

		String sql = "insert into basket values(basketId.nextval,?,?)";

		try {
			String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "JSP", "123123");
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, basket.getB_memberId());
			pstmt.setInt(2, basket.getB_productId());

			pstmt.executeUpdate();
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int basketId) {
		// TODO Auto-generated method stub
		String sql = "delete from basket where basketId=?";
		try {
			String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "JSP", "123123");
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, basketId);
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