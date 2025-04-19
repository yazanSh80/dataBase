package com.example.database;

import java.time.LocalDate;

public class Manufacturing {
	private final int productId;
	private final String category;
	private float price;
	private final LocalDate manufacturingDate;
	private int itemsneeded;

	public Manufacturing(int productId, String category, float price, LocalDate manufacturingDate, int Itemsneeded) {

		this.productId = productId;
		this.category = category;
		this.price = price;
		this.manufacturingDate = manufacturingDate;
		this.itemsneeded = Itemsneeded;
	}

	public int getItemsneeded() {
		return itemsneeded;
	}

	public void setItemsneeded(int itemsneeded) {
		this.itemsneeded = itemsneeded;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public String getCategory() {
		return category;
	}

	public float getPrice() {
		return price;
	}

	public LocalDate getManufacturingDate() {
		return manufacturingDate;
	}

}
