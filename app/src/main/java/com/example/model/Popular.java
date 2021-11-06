package com.example.model;

import java.io.Serializable;

public class Popular implements Serializable{
    private   int Thumb;
    private   String Name;
    private   String  Description;
    private   String Rate;
    private   Double Price;
    private int numberInCard;

    public Popular(int thumb, String name, String description, String rate, Double price) {
        Thumb = thumb;
        Name = name;
        Description = description;
        Rate = rate;
        Price = price;
    }

    public Popular(int thumb, String name, String description, String rate, Double price, int numberInCard) {
        Thumb = thumb;
        Name = name;
        Description = description;
        Rate = rate;
        Price = price;
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

    public String getRate() {
        return Rate;
    }

    public void setRate(String rate) {
        Rate = rate;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public int getNumberInCard() {
        return numberInCard;
    }

    public void setNumberInCard(int numberInCard) {
        this.numberInCard = numberInCard;
    }
}
