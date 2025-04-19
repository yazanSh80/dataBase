package com.example.database;

import java.time.LocalDate;
import java.util.Date;

public class Shipment {
	private String shipmentCode;
	private int orderNum;
	private LocalDate shipmentDate;
	private String shipmentStatus;
	private Float shipmentCost;

	public Shipment(String shipmentCode, int orderNum, LocalDate shipmentDate, String shipmentStatus,
			Float shipmentCost) {
		this.shipmentCode = shipmentCode;
		this.orderNum = orderNum;
		this.shipmentDate = shipmentDate;
		this.shipmentStatus = shipmentStatus;
		this.shipmentCost = shipmentCost;
	}

	public String getShipmentCode() {
		return shipmentCode;
	}

	public void setShipmentCode(String shipmentCode) {
		this.shipmentCode = shipmentCode;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public LocalDate getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(LocalDate shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public String getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	public double getShipmentCost() {
		return shipmentCost;
	}

	public void setShipmentCost(Float shipmentCost) {
		this.shipmentCost = shipmentCost;
	}
}