package dao;

import entity.Purchase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDaoImpl implements PurchaseDao {
	private Connection con = null;
	private PreparedStatement pstmt = null;


	@Override
	public List<Purchase> selectAll() {
		// TODO Auto-generated method stub
		List<Purchase> list = new ArrayList<Purchase>();
		String sql = "select * from member m left join purchase p on m.memberId=p.p_memberId order by m.username asc";
		try {
			String url = "jdbc:oracle:thin:@localhost:1521/orcl";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "sys as sysdba", "1");
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Purchase(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getInt(10),
						rs.getInt(11)));
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
		String sql = "insert into purchase values(purchaseId.nextval,?,?,?,?)";
		try {
			String url = "jdbc:oracle:thin:@localhost:1521/orcl";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "sys as sysdba", "1");
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, purchase.getP_memberId());
			pstmt.setString(2, purchase.getTitle());
			pstmt.setInt(3, purchase.getPrice());
			pstmt.setInt(4, purchase.getQuantity());

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