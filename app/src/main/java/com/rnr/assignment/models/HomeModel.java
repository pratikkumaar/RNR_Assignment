package com.rnr.assignment.models;

/**
 * Created by Prateek on 10-Dec-20.
 */
public class HomeModel {
    private String title;
    private String action;
    private int image;

    public HomeModel(String title, String action, int image) {
        this.title = title;
        this.action = action;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
