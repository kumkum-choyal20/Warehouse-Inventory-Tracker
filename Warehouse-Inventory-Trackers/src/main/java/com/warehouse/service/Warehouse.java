package com.warehouse.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.warehouse.model.Product;
import com.warehouse.observer.StockObserver;
public class Warehouse {
		private String name;
    private StockObserver observer;

    // product ID -> quantity
    private Map<String, Integer> quantities = new HashMap<>();

    // product ID -> threshold
    private Map<String, Integer> thresholds = new HashMap<>();

    public Warehouse(String name, StockObserver observer) {
        this.name = name;
        this.observer = observer;
    }

    public String getName() {
        return name;
    }

    public void addProduct(Product product, int initialQty, int threshold) {
        quantities.put(product.getId(), initialQty);
        thresholds.put(product.getId(), threshold);
        System.out.println("Added " + product.getName() + " in " + name +
                " warehouse (Qty: " + initialQty + ", Threshold: " + threshold + ")");
    }

    public void receiveShipment(Product product, int amount) {
        if (!quantities.containsKey(product.getId())) {
            System.out.println("❌ " + product.getName() + " not found in " + name);
            return;
        }
        int newQty = quantities.get(product.getId()) + amount;
        quantities.put(product.getId(), newQty);
        System.out.println("Shipment received: " + amount + " " + product.getName() + " in " + name);
    }

    public void fulfillOrder(Product product, int amount) {
        if (!quantities.containsKey(product.getId())) {
            System.out.println("❌ " + product.getName() + " not found in " + name);
            return;
        }

        int currentQty = quantities.get(product.getId());
        if (currentQty < amount) {
            System.out.println("❌ Not enough stock for " + product.getName() + " in " + name);
            return;
        }

        int newQty = currentQty - amount;
        quantities.put(product.getId(), newQty);
        System.out.println("Order fulfilled: " + amount + " " + product.getName() + " from " + name);

        int threshold = thresholds.get(product.getId());
        if (newQty < threshold) {
            observer.onLowStock(name, product, newQty);
        }
    }

    public void showInventory(Map<String, Product> allProducts) {
        System.out.println("\n Inventory for " + name + " warehouse:");
        for (String productId : quantities.keySet()) {
            Product p = allProducts.get(productId);
            System.out.println(p.getName() + " → " + quantities.get(productId) + " units");
        }
    }
	}
public class WarehouseSystem {
    private Map<String, Warehouse> warehouses = new HashMap<>();
    private Map<String, Product> products = new HashMap<>();

    public void addWarehouse(Warehouse warehouse) {
        warehouses.put(warehouse.getName(), warehouse);
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public Map<String, Product> getProducts() {
        return products;
    }

    public Warehouse getWarehouse(String name) {
        return warehouses.get(name);
    }
}


