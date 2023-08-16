package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Purchase;

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
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11)));
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
			pstmt.setString(3, purchase.getPrice());
			pstmt.setString(4, purchase.getQuantity());

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
