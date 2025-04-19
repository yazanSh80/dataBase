package com.example.database;

import java.time.LocalDate;

public class Supplier {
	private int supplierId;
	private String supplierName;
	private LocalDate supplierDate;

	public Supplier(int supplierId, String supplierName, LocalDate supplierDate) {
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplierDate = supplierDate;
	}

	// Getters
	public int getSupplierId() {
		return supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public LocalDate getSupplierDate() {
		return supplierDate;
	}

	// Setters (optional)
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public void setSupplierDate(LocalDate supplierDate) {
		this.supplierDate = supplierDate;
	}
}
