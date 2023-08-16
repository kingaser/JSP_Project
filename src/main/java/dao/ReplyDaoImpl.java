package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Reply;

public class ReplyDaoImpl implements ReplyDao {
	private Connection con = null;
	private PreparedStatement pstmt = null;

	@Override
	public List<Reply> selectAll() {
		// TODO Auto-generated method stub
		List<Reply> list = new ArrayList<Reply>();
		String sql = "select * from (select * from member m left join reply r on m.memberId=r.r_memberId order by m.username asc) a left join product p on a.r_productId=p.productId order by a.username asc";
		try {
			String url = "jdbc:oracle:thin:@localhost:1521/orcl";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "sys as sysdba", "1");
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Reply(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getString(10), rs.getInt(11),
						rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16),
						rs.getString(17)));
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
	public void register(Reply reply) {
		// TODO Auto-generated method stub

		String sql = "insert into reply values(replyId.nextval,?,?,?)";

		try {
			String url = "jdbc:oracle:thin:@localhost:1521/orcl";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "sys as sysdba", "1");
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reply.getR_memberId());
			pstmt.setInt(2, reply.getR_productId());
			pstmt.setString(3, reply.getReplycontent());

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
	public void delete(int replyId) {
		// TODO Auto-generated method stub
		String sql = "delete from reply where replyid=?";
		try {
			String url = "jdbc:oracle:thin:@localhost:1521/orcl";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "sys as sysdba", "1");
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, replyId);
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
