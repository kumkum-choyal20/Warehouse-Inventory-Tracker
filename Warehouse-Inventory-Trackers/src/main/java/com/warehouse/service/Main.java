package com.warehouse.service;

import com.warehouse.model.Product;
import com.warehouse.observer.AlertService;

public class Main {
    public static void main(String[] args) {
        StockObserver alertService = new AlertService();
        WarehouseSystem system = new WarehouseSystem();

        // Create products
        Product laptop = new Product("P001", "Laptop");
        Product phone = new Product("P002", "Smartphone");

        system.addProduct(laptop);
        system.addProduct(phone);

        // Create warehouses
        Warehouse delhi = new Warehouse("Delhi", alertService);
        Warehouse mumbai = new Warehouse("Mumbai", alertService);

        system.addWarehouse(delhi);
        system.addWarehouse(mumbai);

        // Add products to warehouses with their own quantity + threshold
        delhi.addProduct(laptop, 10, 5);
        delhi.addProduct(phone, 8, 3);

        mumbai.addProduct(laptop, 3, 2);
        mumbai.addProduct(phone, 12, 4);

        // Fulfill some orders
        delhi.fulfillOrder(laptop, 7);  // OK
        delhi.fulfillOrder(laptop, 3);  // ALERT triggers

        mumbai.fulfillOrder(laptop, 2); // ALERT triggers
        mumbai.fulfillOrder(phone, 9);  // OK

        // Show inventories
        delhi.showInventory(system.getProducts());
        mumbai.showInventory(system.getProducts());
    }
}
