package com.example.database;

import java.time.LocalDate;
import java.util.Date;

public class Order {
	private int orderNum;
	private String shipCode;
	private int customerID;
	private LocalDate orderDate;
	private Float orderSum;
	private int EmpID;

	/*
	 * OrderNum INT NOT NULL, CustomerID INT NOT NULL, OrderDate DATE NOT NULL,
	 * OrderSum DECIMAL(10,2) NOT NULL, ShipCode VARCHAR(255) NOT NULL, PRIMARY KEY
	 * (OrderNum), empId int not null,
	 * 
	 * 
	 * 
	 */
	public boolean sameOrder(int OrderNum) {
		if (this.orderNum == OrderNum)
			return true;
		else
			return false;
	}

	public Order(int orderNum, String shipCode, int customerID, LocalDate orderDate, float orderSum, int EmpId) {
		this.orderNum = orderNum;
		this.shipCode = shipCode;
		this.customerID = customerID;
		this.orderDate = orderDate;
		this.EmpID = EmpId;
		this.orderSum = orderSum;
	}

	public int getEmpID() {
		return EmpID;
	}

	public void setEmpID(int empID) {
		EmpID = empID;
	}

	public void setOrderSum(Float orderSum) {
		this.orderSum = orderSum;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public String getShipCode() {
		return shipCode;
	}

	public void setShipCode(String shipCode) {
		this.shipCode = shipCode;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public double getOrderSum() {
		return orderSum;
	}

	public void setOrderSum(float orderSum) {
		this.orderSum = orderSum;
	}
}
