package com.warehouse.observer;

import com.warehouse.model.Product;

public class AlertService implements StockObserver {

	@Override
	public void onLowStock(Product product) {
		System.out.println("  Restock Alert: Low stock for " + product.getName() + " – only " + product.getQuantity()
		+ " left (Threshold: " + product.getReorderThreshold() + ")");
		
	}
}
