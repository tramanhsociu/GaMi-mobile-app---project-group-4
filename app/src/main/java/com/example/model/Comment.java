package com.example.model;

public class Comment {
    private int blog_id;
    private int blog_image;
    private String blog_content;

    public Comment(int blog_id, int blog_image, String blog_content) {

        this.blog_id = blog_id;
        this.blog_image = blog_image;
        this.blog_content = blog_content;
    }

    public int getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
    }

    public int getBlog_image() {
        return blog_image;
    }

    public void setBlog_image(int blog_image) {
        this.blog_image = blog_image;
    }

    public String getBlog_content() {
        return blog_content;
    }

    public void setBlog_content(String blog_content) {
        this.blog_content = blog_content;
    }
}
