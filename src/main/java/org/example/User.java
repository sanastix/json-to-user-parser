package org.example;

public class User {

    private String name;
    private int year;
    private boolean isAdmin;

    public User(){}

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    @Override
    public String toString() {
        return "User: " +
                "name = " + name +
                ", year = " + year +
                ", isAdmin = " + isAdmin;
    }

    public User(String name, int year, boolean isAdmin) {
        this.name = name;
        this.year = year;
        this.isAdmin = isAdmin;
    }
}
