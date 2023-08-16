package dao;

import java.util.List;

import entity.Product;

public interface ProductDao {
	void insert(Product product);

	Product getbyTitle(String title);

	void modify(Product product);

	void delete(int productId);

	List<Product> selectAll();
}