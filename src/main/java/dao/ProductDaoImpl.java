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
        String sql = "select * from product order by PRODUCTID asc";
        try {
            String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, "JSP", "123123");
            pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                list.add(new Product(rs.getInt("PRODUCTID"), rs.getString("TITLE"), rs.getString("AUTHOR"),
                        rs.getString("PRICE"), rs.getString("QUANTITY"), rs.getString("IMAGE"), rs.getString("CONTENT")));
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
    public Product selectById(int id) {
        // TODO Auto-generated method stub
        Product product = null;
        String sql = "select * from product where PRODUCTID = ?";
        try {
            String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, "JSP", "123123");
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                product = new Product(rs.getInt("PRODUCTID"), rs.getString("TITLE"),
                        rs.getString("AUTHOR"), rs.getString("PRICE"),
                        rs.getString("QUANTITY"), rs.getString("IMAGE"),
                        rs.getString("CONTENT"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
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
            String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, "JSP", "123123");
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, product.getTitle());
            pstmt.setString(2, product.getAuthor());
            pstmt.setString(3, product.getContent());
            pstmt.setString(4, product.getPrice());
            pstmt.setString(5, product.getQuantity());
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
        String sql = "update product set quantity=? where productId=?";
        try {
            String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, "JSP", "123123");
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, product.getQuantity());
            pstmt.setInt(2, product.getProductId());
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
            String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, "JSP", "123123");
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

    @Override
    public List<Product> searchByTitle(String title) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from product where title like '%' || ? || '%' order by productid asc";
        try {
            String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, "JSP", "123123");
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, title);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                list.add(new Product(rs.getInt("PRODUCTID"), rs.getString("TITLE"), rs.getString("AUTHOR"),
                        rs.getString("PRICE"), rs.getString("QUANTITY"), rs.getString("IMAGE"), rs.getString("CONTENT")));
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

}