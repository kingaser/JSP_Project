package service;

import java.util.List;

import entity.Purchase;

public interface PurchaseService {

	void buy(Purchase purchase);

	List<Purchase> getPurchases();
}