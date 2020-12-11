package com.rnr.assignment.models;

/**
 * Created by Prateek on 10-Dec-20.
 */
public class LeaderboardModel {
    private String rank;
    private String name;
    private String points;
    private int img;

    public LeaderboardModel(String rank, String name, String points, int img) {
        this.rank = rank;
        this.name = name;
        this.points = points;
        this.img = img;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
