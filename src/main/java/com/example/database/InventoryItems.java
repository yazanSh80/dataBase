package com.example.database;

public class InventoryItems {
	private int ItemId;
	private String modelType;
	private Float modelPrice;
	private int suplierId;

	/*
	 * 
	 * ModelType varchar(255) NOT NULL, ModelPrice decimal(10,2) NOT NULL, PRIMARY
	 * KEY (ItemID), SuplierID int, foreign key (SuplierID) REFERENCES
	 * Suplier(SuplierID) on delete cascade on update cascade
	 */

	public InventoryItems(int itemId, String modelType, Float modelPrice, int suplierId) {

		this.ItemId = itemId;
		this.modelType = modelType;
		this.modelPrice = modelPrice;
		this.suplierId = suplierId;
	}

	public int getItemId() {
		return ItemId;
	}

	public void setItemId(int itemId) {
		ItemId = itemId;
	}

	public int getSuplierId() {
		return suplierId;
	}

	public void setSuplierId(int suplierId) {
		this.suplierId = suplierId;
	}

	public String getModelType() {
		return modelType;
	}

	public void setModelType(String modelType) {
		this.modelType = modelType;
	}

	public double getModelPrice() {
		return modelPrice;
	}

	public void setModelPrice(Float modelPrice) {
		this.modelPrice = modelPrice;
	}

}
