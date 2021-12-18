package com.example.model;

public class InfoOrder {

    private int orderThumb;
    private String orderName;
    private String orderContent;
    private String orderTime;
    private int showInfo;

    public int getOrderThumb() {
        return orderThumb;
    }

    public void setOrderThumb(int orderThumb) {
        this.orderThumb = orderThumb;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(String orderContent) {
        this.orderContent = orderContent;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public int getShowInfo() {
        return showInfo;
    }

    public void setShowInfo(int showInfo) {
        this.showInfo = showInfo;
    }

    public InfoOrder(int orderThumb, String orderName, String orderContent, String orderTime, int showInfo) {
        this.orderThumb = orderThumb;
        this.orderName = orderName;
        this.orderContent = orderContent;
        this.orderTime = orderTime;
        this.showInfo = showInfo;
    }
}
