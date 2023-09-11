package dao;

import java.util.List;

import entity.Product;

public interface ProductDao {
	void insert(Product product);

	void modify(Product product);

	void delete(String title);

	Product selectByTitle(String title);

	List<Product> selectAll();

	Product selectById(int id);

	List<Product> searchByTitle(String title);
}