package com.example.database;

import java.time.LocalDate;

public class CustomerPurchase {	  
	        private final int customerID;
	        private final String category;
	        private final int orderNum;
	        private final int productID;
	        private final float price;
	        private final LocalDate date;

	        public CustomerPurchase(int customerID, String category, int orderNum, int productID, float price, LocalDate date) {
	            this.customerID = customerID;
	            this.category = category;
	            this.orderNum = orderNum;
	            this.productID = productID;
	            this.price = price;
	            this.date = date;
	        }

	        public int getCustomerID() {
	            return customerID;
	        }

	        public String getCategory() {
	            return category;
	        }

	        public int getOrderNum() {
	            return orderNum;
	        }

	        public int getProductID() {
	            return productID;
	        }

	        public float getPrice() {
	            return price;
	        }

	        public LocalDate getDate() {
	            return date;
	        }
	    }