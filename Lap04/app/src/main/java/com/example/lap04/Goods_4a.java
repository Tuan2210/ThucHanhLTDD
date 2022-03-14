package com.example.lap04;

public class Goods_4a {
    private int id;
    private String name;
    private String shopName;
    private int imgGoods;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getImgGoods() {
        return imgGoods;
    }

    public void setImgGoods(int imgGoods) {
        this.imgGoods = imgGoods;
    }

    public Goods_4a(int id, String name, String shopName, int imgGoods) {
        this.id = id;
        this.name = name;
        this.shopName = shopName;
        this.imgGoods = imgGoods;
    }
}
