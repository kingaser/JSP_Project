package service;

import java.util.List;

import entity.Basket;
import entity.Member;
import entity.Product;

public interface BasketService {

	void addBasket(Basket basket);

	void deleteBasket(int basketId);

	Basket getByUsername(String username);

	List<Basket> getBaskets();
}
