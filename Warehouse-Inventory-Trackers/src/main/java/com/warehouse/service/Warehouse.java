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
		private final Map<String, Product> inventory = new HashMap<>();
		private final List<StockObserver> observers = new ArrayList<>();

		// Optional persistence file
		private final String PERSISTENCE_FILE = "inventory.txt";

		/** Register a new observer (e.g. AlertService) */
		public void addObserver(StockObserver observer) {
			observers.add(observer);
		}

		/** Add a new product to the warehouse */
		public void addProduct(Product product) {
			if (inventory.containsKey(product.getProductId())) {
				System.out.println("Product with ID " + product.getProductId() + " already exists!");
				return;
			}
			inventory.put(product.getProductId(), product);
			System.out.println(" Product added: " + product);
		}

		/** Receive a shipment (increase stock) */
		public void receiveShipment(String productId, int quantity) {
			Product p = inventory.get(productId);
			if (p == null) {
				System.out.println(" Error: Invalid Product ID!");
				return;
			}
			if (quantity <= 0) {
				System.out.println(" Error: Shipment quantity must be positive!");
				return;
			}
			p.setQuantity(p.getQuantity() + quantity);
			System.out.println(
					" Shipment received: " + quantity + " units of " + p.getName() + " (Total: " + p.getQuantity() + ")");
		}

		/** Fulfill a customer order (decrease stock) */
		public void fulfillOrder(String productId, int quantity) {
			Product p = inventory.get(productId);
			if (p == null) {
				System.out.println(" Error: Invalid Product ID!");
				return;
			}
			if (quantity <= 0) {
				System.out.println(" Error: Order quantity must be positive!");
				return;
			}
			if (p.getQuantity() < quantity) {
				System.out.println("  Insufficient stock for " + p.getName() + ". Available: " + p.getQuantity());
				return;
			}

			p.setQuantity(p.getQuantity() - quantity);
			System.out.println(
					" Order fulfilled: " + quantity + " units of " + p.getName() + " (Remaining: " + p.getQuantity() + ")");

			if (p.getQuantity() < p.getReorderThreshold()) {
				notifyLowStock(p);
			}
		}

		/** Notify all observers about low stock */
		private void notifyLowStock(Product product) {
			for (StockObserver o : observers) {
				o.onLowStock(product);
			}
		}

		/** Display all products */
		public void showInventory() {
			System.out.println("\n Current Inventory:");
			for (Product p : inventory.values()) {
				System.out.println("  " + p);
			}
		}

		/** Optional: Save inventory state to file */
		public void saveToFile() {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(PERSISTENCE_FILE))) {
				for (Product p : inventory.values()) {
					bw.write(p.getProductId() + "," + p.getName() + "," + p.getQuantity() + "," + p.getReorderThreshold());
					bw.newLine();
				}
				System.out.println(" Inventory saved to file.");
			} catch (IOException e) {
				System.out.println("Error saving to file: " + e.getMessage());
			}
		}

		/** Optional: Load inventory from file */
		public void loadFromFile() {
			File file = new File(PERSISTENCE_FILE);
			if (!file.exists())
				return;

			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				String line;
				while ((line = br.readLine()) != null) {
					String[] data = line.split(",");
					if (data.length == 4) {
						Product p = new Product(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]));
						inventory.put(p.getProductId(), p);
					}
				}
				System.out.println("Inventory loaded from file.");
			} catch (IOException e) {
				System.out.println(" Error loading file: " + e.getMessage());
			}
		}
	}


