package com.example.lap07;

public class Place {
    private int idPlace;
    private String namePlace;
    private int imgUpdate;
    private int imgDelete;

    public int getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(int idPlace) {
        this.idPlace = idPlace;
    }

    public String getNamePlace() {
        return namePlace;
    }

    public void setNamePlace(String namePlace) {
        this.namePlace = namePlace;
    }

    public int getImgUpdate() {
        return imgUpdate;
    }

    public void setImgUpdate(int imgUpdate) {
        this.imgUpdate = imgUpdate;
    }

    public int getImgDelete() {
        return imgDelete;
    }

    public void setImgDelete(int imgDelete) {
        this.imgDelete = imgDelete;
    }

    public Place(int idPlace, String namePlace, int imgUpdate, int imgDelete) {
        this.idPlace = idPlace;
        this.namePlace = namePlace;
        this.imgUpdate = imgUpdate;
        this.imgDelete = imgDelete;
    }

    public Place(String namePlace, int imgUpdate, int imgDelete) {
        this.namePlace = namePlace;
        this.imgUpdate = imgUpdate;
        this.imgDelete = imgDelete;
    }

    @Override
    public String toString() {
        return "Place{" +
                "idPlace=" + idPlace +
                ", namePlace='" + namePlace + '\'' +
                ", imgUpdate=" + imgUpdate +
                ", imgDelete=" + imgDelete +
                '}';
    }
}
