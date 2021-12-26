package com.example.model;

public class Customer {
    private String customerName;
    private boolean customerGender;
    private String customerPhone;
    private String customerAddress;
    private int customerAvatar;

    public Customer(String customerName, boolean customerGender, String customerPhone, String customerAddress, int customerAvatar) {
        this.customerName = customerName;
        this.customerGender = customerGender;
        this.customerPhone = customerPhone;
        this.customerAddress = customerAddress;
        this.customerAvatar = customerAvatar;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public boolean getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(boolean customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public int getCustomerAvatar() {
        return customerAvatar;
    }

    public void setCustomerAvatar(int customerAvatar) {
        this.customerAvatar = customerAvatar;
    }
}
