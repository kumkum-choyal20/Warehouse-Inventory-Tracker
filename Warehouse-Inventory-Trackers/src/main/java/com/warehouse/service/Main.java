package com.warehouse.service;

import com.warehouse.model.Product;
import com.warehouse.observer.AlertService;

public class Main {
	public static void main(String[] args) {
		Warehouse warehouse = new Warehouse();
		warehouse.loadFromFile();
		warehouse.addObserver(new AlertService());
		warehouse.addProduct(new Product("P001", "Laptop", 0, 5));
		warehouse.addProduct(new Product("P002", "Monitor", 2, 3));
		warehouse.receiveShipment("P001", 10);
		warehouse.receiveShipment("P002", 5);
		warehouse.showInventory();

		// Fulfill some orders
		warehouse.fulfillOrder("P001", 6); // Will trigger low stock alert
		warehouse.fulfillOrder("P002", 3);
        warehouse.showInventory();

		// Save inventory state
		warehouse.saveToFile();
	}
}
