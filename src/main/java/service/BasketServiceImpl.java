package service;

import java.util.List;

import dao.BasketDao;
import dao.BasketDaoImpl;
import entity.Basket;
import entity.Member;
import entity.Product;

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
	public void deleteBasket(String username) {
		// TODO Auto-generated method stub
		basketDao.delete(username);
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
