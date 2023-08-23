package service;

import entity.Basket;

import java.util.List;

public interface BasketService {

	void addBasket(Basket basket);

	void deleteBasket(int basketId);

	Basket getByUsername(String username);

	List<Basket> getBaskets(int id);
}