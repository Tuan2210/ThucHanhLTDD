package com.example.lap06;

public class Shoes {
    private int id;
    private String description;
    private int image;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shoes(int id, String description, int image, String name) {
        this.id = id;
        this.description = description;
        this.image = image;
        this.name = name;
    }
}
