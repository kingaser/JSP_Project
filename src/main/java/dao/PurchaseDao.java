package dao;

import entity.Purchase;

import java.util.List;

public interface PurchaseDao {

	void insert(Purchase purchase);

	List<Purchase> selectAll(int memberId);
}