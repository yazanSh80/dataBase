package com.example.database;

public class Customer {
    private int customerID;
    private String customerName;
    private String customerEmail;
    private String customerAddress;
    private String customerPhone;

    public Customer(int customerID,String customerName,String customerEmail,String customerAddress,String customerPhone) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

	@Override
	public String toString() {
		return customerName +"  with the ID  "+ customerID +" with the Email "+ customerEmail +" with the Phone  "+ customerPhone;
	}
    
}