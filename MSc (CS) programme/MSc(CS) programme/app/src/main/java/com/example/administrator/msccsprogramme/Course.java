package com.example.administrator.msccsprogramme;

public class Course {
    private String courseIndex;
    private String courseTitle;
    private int backgroundColor;

    public Course(String courseIndex, String courseTitle, int backgroundColor){
        this.courseIndex = courseIndex;
        this.courseTitle = courseTitle;
        this.backgroundColor = backgroundColor;
    }

    public String getCourseIndex(){
        return courseIndex;
    }

    public String getCourseTitle(){
        return courseTitle;
    }

    public int getBackgroundColor(){
        return backgroundColor;
    }
}
