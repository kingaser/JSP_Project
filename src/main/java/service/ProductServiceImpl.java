package service;

import java.util.List;

import dao.ProductDao;
import dao.ProductDaoImpl;
import entity.Product;

public class ProductServiceImpl implements ProductService {
	ProductDao productDao = null;

	public ProductServiceImpl() {
		// TODO Auto-generated constructor stub
		productDao = new ProductDaoImpl();
	}

	@Override
	public void register(Product product) {
		// TODO Auto-generated method stub
		productDao.insert(product);
	}

	@Override
	public void editProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.modify(product);
	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		productDao.delete(String.valueOf(productId));
	}

	@Override
	public Product getProductByTitle(String title) {
		return null;
	}

	@Override
	public Product getProduct(int id) {
		return productDao.selectById(id);
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return productDao.selectAll();
	}

	@Override
	public List<Product> getSearchProducts(String title) {
		return productDao.searchByTitle(title);
	}

}