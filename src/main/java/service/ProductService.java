package service;

import java.util.List;

import entity.Product;

public interface ProductService {

	void register(Product product);

	void editProduct(Product product);

	void deleteProduct(String title);

	Product getProductByTitle(String title);

	List<Product> getProducts();
}
