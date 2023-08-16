package service;

import java.util.List;

import dao.PurchaseDao;
import dao.PurchaseDaoImpl;
import entity.Member;
import entity.Purchase;

public class PurchaseServiceImpl implements PurchaseService {
	PurchaseDao purchaseDao;

	public PurchaseServiceImpl() {
		// TODO Auto-generated constructor stub
		purchaseDao = new PurchaseDaoImpl();
	}

	@Override
	public void buy(Purchase purchase) {
		// TODO Auto-generated method stub
		purchaseDao.insert(purchase);
	}

	public List<Purchase> getPurchases() {
		return purchaseDao.selectAll();
	}
}