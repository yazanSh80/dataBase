package com.example.database;

public class OrderLine {
	private final int orderNum;
	private final int productID;
	private final int invoiceID;
	private final float price;

	public OrderLine(int orderNum, int productID, int invoiceID, float price) {
		this.orderNum = orderNum;
		this.productID = productID;
		this.invoiceID = invoiceID;
		this.price = price;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public int getProductID() {
		return productID;
	}

	public int getInvoiceID() {
		return invoiceID;
	}

	public float getPrice() {
		return price;
	}
}