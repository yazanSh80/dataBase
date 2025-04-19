package com.example.database;

public class ModelSupplier {
	private int ItemId;
	private int SupplierID;
	private String ModelType;
	private String SupplierName;

	public ModelSupplier(int ItemId, int SupplierId, String modelType, String SupplierName) {
		this.ItemId = ItemId;
		this.ModelType = modelType;
		this.SupplierID = SupplierId;
		this.SupplierName = SupplierName;
	}

	public String getSupplierName() {
		return SupplierName;
	}

	public void setSupplierName(String supplierName) {
		SupplierName = supplierName;
	}

	public String getModelType() {
		return ModelType;
	}

	public void setModelType(String modelType) {
		ModelType = modelType;
	}

	public int getSupplierID() {
		return SupplierID;
	}

	public void setSupplierID(int supplierID) {
		SupplierID = supplierID;
	}

	public int getItemId() {
		return ItemId;
	}

	public void setItemId(int itemId) {
		ItemId = itemId;
	}
}
