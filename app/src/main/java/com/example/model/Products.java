package com.example.model;

import java.io.Serializable;

public class Products implements Serializable{
    private   int Thumb;
    private   String Name;
    private   String  Description;
    private   float Rate;
    private   Double Price;
    private String Category;
    private int numberInCard;

    public Products(int thumb, String name, String description, float rate, Double price, String category, int numberInCard) {
        Thumb = thumb;
        Name = name;
        Description = description;
        Rate = rate;
        Price = price;
        Category = category;
        this.numberInCard = numberInCard;
    }

    public int getThumb() {
        return Thumb;
    }

    public void setThumb(int thumb) {
        Thumb = thumb;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public float getRate() {
        return Rate;
    }

    public void setRate(float rate) {
        Rate = rate;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public int getNumberInCard() {
        return numberInCard;
    }

    public void setNumberInCard(int numberInCard) {
        this.numberInCard = numberInCard;
    }
}
