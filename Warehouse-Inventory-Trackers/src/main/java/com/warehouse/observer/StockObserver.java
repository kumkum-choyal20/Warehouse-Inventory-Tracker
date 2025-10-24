package com.warehouse.observer;

import com.warehouse.model.Product;

public interface StockObserver {
	void onLowStock(Product product);
}
