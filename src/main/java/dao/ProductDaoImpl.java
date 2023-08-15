package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Product;
import util.dbconn;

public class ProductDaoImpl implements ProductDao {
	Connection con = null;
	dbconn db = null;

	public ProductDaoImpl() {
		// TODO Auto-generated constructor stub
		db = new dbconn();
		con = db.getConnection();
	}

	@Override
	public List<Product> selectAll() {
		// TODO Auto-generated method stub
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from product order by title asc";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7)));
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
	public Product getByTitle(String title) {
		// TODO Auto-generated method stub
		Product product = null;
		String sql = "select * from product where title=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
			}

			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public void insert(Product product) {
		// TODO Auto-generated method stub

		String sql = "insert into product values(productId.nextval,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product.getTitle());
			pstmt.setString(2, product.getAuthor());
			pstmt.setString(3, product.getProductcontent());
			pstmt.setString(4, product.getPrice());
			pstmt.setString(5, product.getQuantity());
			pstmt.setString(6, product.getImage());

			pstmt.executeUpdate();

			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void modify(Product product) {
		// TODO Auto-generated method stub
		String sql = "update product set author=?, price=?, quantity=?, image=? where title=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product.getAuthor());
			pstmt.setString(2, product.getPrice());
			pstmt.setString(3, product.getQuantity());
			pstmt.setString(4, product.getImage());
			pstmt.setString(5, product.getTitle());
			pstmt.executeUpdate();

			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String title) {
		// TODO Auto-generated method stub
		String sql = "delete product where title=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.executeUpdate();

			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
