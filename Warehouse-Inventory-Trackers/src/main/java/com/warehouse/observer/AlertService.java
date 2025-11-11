package com.warehouse.observer;

import com.warehouse.model.Product;

public class AlertService implements StockObserver {

	@Override
	 public void onLowStock(String warehouseName, Product product, int currentQuantity) {
        System.out.println("ALERT: Low stock in " + warehouseName + 
                " for " + product.getName() + " – only " + currentQuantity + " left!");
    }
}
