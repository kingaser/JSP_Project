package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Reply;
import util.dbconn;

public class ReplyDaoImpl implements ReplyDao {
	dbconn db = null;
	Connection con = null;

	public ReplyDaoImpl() {
		// TODO Auto-generated constructor stub
		db = new dbconn();
		con = db.getConnection();
	}

	@Override
	public List<Reply> selectAll() {
		// TODO Auto-generated method stub
		List<Reply> list = new ArrayList<Reply>();
		String sql = "select * from (select * from member m left join reply r on m.memberId=r.r_memberId order by m.username asc) a left join product p on a.r_productId=p.productId order by a.username asc";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Reply(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getString(10), rs.getInt(11),
						rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16),
						rs.getString(17)));
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
	public void register(Reply reply) {
		// TODO Auto-generated method stub

		String sql = "insert into reply values(replyId.nextval,?,?,?)";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reply.getR_memberId());
			pstmt.setInt(2, reply.getR_productId());
			pstmt.setString(3, reply.getReplycontent());

			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String username) {
		// TODO Auto-generated method stub
		String sql = "delete reply where username=?";
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
