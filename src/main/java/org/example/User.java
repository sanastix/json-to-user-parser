package org.example;

public class User {

    private String name;
    private int year;
    private boolean isAdmin;

    public User() {}

    public User(String name, int year, boolean isAdmin) {
        this.name = name;
        this.year = year;
        this.isAdmin = isAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "User {" +
                "name = " + name +
                ", year = " + year +
                ", isAdmin = " + isAdmin +
                '}';
    }

}
