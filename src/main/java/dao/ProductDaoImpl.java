package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Product;

public class ProductDaoImpl implements ProductDao {
    private Connection con = null;
    private PreparedStatement pstmt = null;

    @Override
    public List<Product> selectAll() {
        // TODO Auto-generated method stub
        List<Product> list = new ArrayList<>();
        String sql = "select * from product order by title asc";
        try {
            String url = "jdbc:oracle:thin:@localhost:1521/orcl";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, "sys as sysdba", "1");
            pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
                        rs.getInt(6), rs.getString(7)));
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

//    @Override
//    public Product selectByTitle(String title) {
//        String sql = "SELECT * FROM PRODUCT WHERE TITLE=?";
//        Product product = null;
//
//        try {
//			String url = "jdbc:oracle:thin:@localhost:1521/orcl";
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection(url, "sys as sysdba", "1");
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, title);
//			ResultSet rs = pstmt.executeQuery();
////			while (rs.next()) {
////				product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
////						rs.getInt(6), rs.getString(7));
////			}
//            rs.next();
//            product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
//						rs.getInt(6), rs.getString(7));
//
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        return product;
//	}

//	@Override
//	public Product selectByTitle(String title) {
//		// TODO Auto-generated method stub
//		Product product = null;
//		String sql = "select * from product where title=?";
//		try {
//			String url = "jdbc:oracle:thin:@localhost:1521/orcl";
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection(url, "sys as sysdba", "1");
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, title);
//			ResultSet rs = pstmt.executeQuery();
//			if (rs.next()) {
//				product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
//						rs.getInt(6), rs.getString(7));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return product;
//	}

    @Override
    public void insert(Product product) {
        // TODO Auto-generated method stub

        String sql = "insert into product values(productId.nextval,?,?,?,?,?,?)";
        try {
            String url = "jdbc:oracle:thin:@localhost:1521/orcl";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, "sys as sysdba", "1");
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, product.getTitle());
            pstmt.setString(2, product.getAuthor());
            pstmt.setString(3, product.getProductContent());
            pstmt.setInt(4, product.getPrice());
            pstmt.setInt(5, product.getQuantity());
            pstmt.setString(6, product.getImage());

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
    public void modify(Product product) {
        // TODO Auto-generated method stub
        String sql = "update product set author=?, price=?, quantity=?, image=? where productId=?";
        try {
            String url = "jdbc:oracle:thin:@localhost:1521/orcl";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, "sys as sysdba", "1");
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, product.getAuthor());
            pstmt.setInt(2, product.getPrice());
            pstmt.setInt(3, product.getQuantity());
            pstmt.setString(4, product.getImage());
            pstmt.setInt(5, product.getProductId());
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
    public void delete(String title) {
        // TODO Auto-generated method stub
        String sql = "delete from product where title=?";
        try {
            String url = "jdbc:oracle:thin:@localhost:1521/orcl";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, "sys as sysdba", "1");
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, title);
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
    public Product selectByTitle(String title) {
        return null;
    }

}