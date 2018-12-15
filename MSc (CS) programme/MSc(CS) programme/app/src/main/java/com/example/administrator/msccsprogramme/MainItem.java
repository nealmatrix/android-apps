package com.example.administrator.msccsprogramme;

public class MainItem {
    private String name;
    private int imageId;

    public MainItem(String name, int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }
}
