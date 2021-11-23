package com.example.lab10_sqlite;

public class Products {
    int id;
    String title,des,thumnail;

    public Products(String title, String des) {
    }

    public Products(int id,String title,String des,String thumnail) {
        this.id = id;
        this.title = title;
        this.des = des;
        this.thumnail = thumnail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getThumnail() {
        return thumnail;
    }

    public void setThumnail(String thumnail) {
        this.thumnail = thumnail;
    }
}
