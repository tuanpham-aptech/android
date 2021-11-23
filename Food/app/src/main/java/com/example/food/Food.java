package com.example.food;

public class Food {
    int id;
    String title,content;
    float price;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public float getPrice() {
        return price;
    }

    public Food(int id, String title, String context, float price) {
        this.id = id;
        this.title = title;
        this.content = context;
        this.price = price;
    }
}


