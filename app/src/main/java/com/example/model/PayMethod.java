package com.example.model;

public class PayMethod {
    private int payThumb;
    private String payTitle;
    private int payArrow;

    public int getPayThumb() {
        return payThumb;
    }

    public void setPayThumb(int payThumb) {
        this.payThumb = payThumb;
    }

    public String getPayTitle() {
        return payTitle;
    }

    public void setPayTitle(String payTitle) {
        this.payTitle = payTitle;
    }

    public int getPayArrow() {
        return payArrow;
    }

    public void setPayArrow(int payArrow) {
        this.payArrow = payArrow;
    }

    public PayMethod(int payThumb, String payTitle, int payArrow) {
        this.payThumb = payThumb;
        this.payTitle = payTitle;
        this.payArrow = payArrow;
    }
}
