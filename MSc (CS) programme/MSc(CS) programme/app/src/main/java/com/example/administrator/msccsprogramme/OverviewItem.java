package com.example.administrator.msccsprogramme;

public class OverviewItem {
    private int backgroundID;
    private String title;
    private int contentID;

    public OverviewItem(int backgroundID, String title, int contentID){
        this.backgroundID = backgroundID;
        this.title = title;
        this.contentID = contentID;
    }

    public int getBackgroundID(){
        return backgroundID;
    }

    public String getTitle(){
        return title;
    }

    public int getContentID(){
        return contentID;
    }

}