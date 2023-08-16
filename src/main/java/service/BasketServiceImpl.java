package service;

import dao.BasketDao;
import dao.BasketDaoImpl;
import entity.Basket;

import java.util.List;

public class BasketServiceImpl implements BasketService {
	BasketDao basketDao = null;

	public BasketServiceImpl() {
		// TODO Auto-generated constructor stub
		basketDao = new BasketDaoImpl();
	}

	@Override
	public void addBasket(Basket basket) {
		// TODO Auto-generated method stub
		basketDao.insert(basket);
	}

	@Override
	public void deleteBasket(int basketId) {
		// TODO Auto-generated method stub
		basketDao.delete(basketId);
	}

	@Override
	public Basket getByUsername(String username) {
		// TODO Auto-generated method stub
		return basketDao.getByUsername(username);
	}

	@Override
	public List<Basket> getBaskets() {
		// TODO Auto-generated method stub
		return basketDao.selectAll();
	}

}