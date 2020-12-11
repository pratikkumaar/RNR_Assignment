package com.rnr.assignment.models;

/**
 * Created by Prateek on 10-Dec-20.
 */
public class LearnWithRNRModel {
    private String title;
    private String shortDescription;
    private int ime;

    public LearnWithRNRModel(String title, String shortDescription, int ime) {
        this.title = title;
        this.shortDescription = shortDescription;
        this.ime = ime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public int getIme() {
        return ime;
    }

    public void setIme(int ime) {
        this.ime = ime;
    }
}
