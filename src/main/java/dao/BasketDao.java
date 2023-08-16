package dao;

import java.util.List;

import entity.Basket;

public interface BasketDao {
	void insert(Basket basket);

	Basket getByUsername(String username);

	void delete(int basketId);

	List<Basket> selectAll();
}
