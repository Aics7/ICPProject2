package com.example.icpproject2;

public class UserPoints {

    String userName;

    String userMail;
    int points;

    public UserPoints() {
    }

    public UserPoints(String userMail, int points) {
        this.userMail = userMail;
        this.points = points;
    }

    public UserPoints(String userName, String userMail, int points) {
        this.userName = userName;
        this.userMail = userMail;
        this.points = points;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
