package com.example.emarket.model;

public class User {
    String token;
    String username;
    String role;
    long points;


    public User() {
        this.token = "";
        this.username = "";
        this.role = "client";
        this.points = 0;
    }

    public User(String token, String username, String role, long points) {
        this.token = token;
        this.username = username;
        this.role = role;
        this.points = points;
    }

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public long getPoints() {
        return points;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "User{" +
                "token='" + token + '\'' +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", points=" + points +
                '}';
    }
}
