package com.example.model;

public class Blog {
    private String Content;
    private int Image;

    public Blog(String content, int image) {
        Content = content;
        Image = image;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
