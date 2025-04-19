package com.example.database;

import java.time.LocalDate;

public class SoldItems {
	private int productId;
	private String category;
	private double price;
	private LocalDate soldDate;

	public SoldItems(int productId, String category, double price, LocalDate soldDate) {
		this.productId = productId;
		this.category = category;
		this.price = price;
		this.soldDate = soldDate;
	}
	public String getCategory() {
		return category;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getPrice() {
		return price;
	}

	public LocalDate getSoldDate() {
		return soldDate;
	}

	// Setters (optional)

	public void setCategory(String category) {
		this.category = category;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setSoldDate(LocalDate soldDate) {
		this.soldDate = soldDate;
	}
}
