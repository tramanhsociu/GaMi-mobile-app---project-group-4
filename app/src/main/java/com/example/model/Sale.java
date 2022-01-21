package com.example.model;

public class Sale {
    private int saleThumb;
    private String saleName;
    private String saleContent;

    public int getSaleThumb() {
        return saleThumb;
    }

    public void setSaleThumb(int saleThumb) {
        this.saleThumb = saleThumb;
    }

    public String getSaleName() {
        return saleName;
    }

    public void setSaleName(String saleName) {
        this.saleName = saleName;
    }

    public String getSaleContent() {
        return saleContent;
    }

    public void setSaleContent(String saleContent) {
        this.saleContent = saleContent;
    }

    public Sale(int saleThumb, String saleName, String saleContent) {
        this.saleThumb = saleThumb;
        this.saleName = saleName;
        this.saleContent = saleContent;
    }
}
