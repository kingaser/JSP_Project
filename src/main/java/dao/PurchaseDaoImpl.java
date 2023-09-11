package dao;

import entity.Purchase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDaoImpl implements PurchaseDao {
	private Connection con = null;
	private PreparedStatement pstmt = null;


	@Override
	public List<Purchase> selectAll(int memberId) {
		// TODO Auto-generated method stub
		List<Purchase> list = new ArrayList<>();
		String sql = "select a.purchaseid, a.price, a.quantity, a.title, b.author, b.image from( " +
				"select * from member m " +
				"left join purchase p " +
				"on m.memberId=p.p_memberId) a " +
				"left join product b " +
				"on a.productId = b.productId " +
				"where a.memberid = ? " +
				"order by purchaseId desc";
		try {
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "JSP", "123123");
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, memberId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Purchase(rs.getInt("purchaseId"),
						rs.getString("price"), rs.getString("quantity"),
						rs.getString("title"), rs.getString("author"),
						rs.getString("image")));
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
	public void insert(Purchase purchase) {
		// TODO Auto-generated method stub
		String sql = "insert into purchase values(purchaseId.nextval,?,?,?,?,?)";
		try {
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "JSP", "123123");
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, purchase.getP_memberId());
			pstmt.setString(2, purchase.getTitle());
			pstmt.setString(3, purchase.getPrice());
			pstmt.setString(4, purchase.getQuantity());
			pstmt.setInt(5, purchase.getP_productId());

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