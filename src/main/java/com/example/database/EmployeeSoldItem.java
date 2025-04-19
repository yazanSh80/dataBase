package com.example.database;

public class EmployeeSoldItem {
    private final int productID;
    private final String category;
    private final int empId;
    private final float price;

    public EmployeeSoldItem(int productID, String category, int empId, float price) {
        this.productID = productID;
        this.category = category;
        this.empId = empId;
        this.price = price;
    }

    public int getProductID() {
        return productID;
    }

    public String getCategory() {
        return category;
    }

    public int getEmpId() {
        return empId;
    }

    public float getPrice() {
        return price;
    }
}