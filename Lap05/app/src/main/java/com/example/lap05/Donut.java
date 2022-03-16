package com.example.lap05;

public class Donut {
    private int id;
    private String donutName;
    private String donutPrice;
    private int imgDonut;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDonutName() {
        return donutName;
    }

    public void setDonutName(String donutName) {
        this.donutName = donutName;
    }

    public String getDonutPrice() {
        return donutPrice;
    }

    public void setDonutPrice(String donutPrice) {
        this.donutPrice = donutPrice;
    }

    public int getImgDonut() {
        return imgDonut;
    }

    public void setImgDonut(int imgDonut) {
        this.imgDonut = imgDonut;
    }

    public Donut(int id, String donutName, String donutPrice, int imgDonut) {
        this.id = id;
        this.donutName = donutName;
        this.donutPrice = donutPrice;
        this.imgDonut = imgDonut;
    }
}
