package com.example.stt19_19468641_dinhquangtuan;

public class Bike {
    private int imgBike;
    private String bikeName;
    private String bikePrice;
    private String loai;

    public int getImgBike() {
        return imgBike;
    }

    public void setImgBike(int imgBike) {
        this.imgBike = imgBike;
    }

    public String getBikeName() {
        return bikeName;
    }

    public void setBikeName(String bikeName) {
        this.bikeName = bikeName;
    }

    public String getBikePrice() {
        return bikePrice;
    }

    public void setBikePrice(String bikePrice) {
        this.bikePrice = bikePrice;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public Bike(int imgBike, String bikeName, String bikePrice, String loai) {
        this.imgBike = imgBike;
        this.bikeName = bikeName;
        this.bikePrice = bikePrice;
        this.loai = loai;
    }
}
