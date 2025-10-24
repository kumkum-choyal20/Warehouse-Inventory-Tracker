package com.warehouse.model;

public class Product {
	private final String productId;
	private String name;
	private int quantity;
	private int reorderThreshold;

	public Product(String productId, String name, int quantity, int reorderThreshold) {
		this.productId = productId;
		this.name = name;
		this.quantity = quantity;
		this.reorderThreshold = reorderThreshold;
	}

	public String getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getReorderThreshold() {
		return reorderThreshold;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setReorderThreshold(int reorderThreshold) {
		this.reorderThreshold = reorderThreshold;
	}

	@Override
	public String toString() {
		return String.format("[%s] %s | Qty: %d | Threshold: %d", productId, name, quantity, reorderThreshold);
	}
}
