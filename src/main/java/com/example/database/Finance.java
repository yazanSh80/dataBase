package com.example.database;

import java.util.Date;
import java.time.LocalDate;
import java.util.Date;

public class Finance {
	private int invoiceID;

	private Float invoiceSum;
	private Float invoiceBills;
	private String invoiceStatus;
	private LocalDate invoiceDate;

	public Finance(int invoiceID, Float invoiceSum, Float invoiceBills, String invoiceStatus, LocalDate invoiceDate) {
		this.invoiceID = invoiceID;
		this.invoiceSum = invoiceSum;
		this.invoiceBills = invoiceBills;
		this.invoiceStatus = invoiceStatus;
		this.invoiceDate = invoiceDate;
	}

	public int getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}

	public double getInvoiceSum() {
		return invoiceSum;
	}

	public void setInvoiceSum(Float invoiceSum) {
		this.invoiceSum = invoiceSum;
	}

	public double getInvoiceBills() {
		return invoiceBills;
	}

	public void setInvoiceBills(Float invoiceBills) {
		this.invoiceBills = invoiceBills;
	}

	public String getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
}