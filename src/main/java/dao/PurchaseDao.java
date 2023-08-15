package dao;

import java.util.List;

import entity.Purchase;

public interface PurchaseDao {

	void insert(Purchase purchase);

	List<Purchase> selectAll();
}
