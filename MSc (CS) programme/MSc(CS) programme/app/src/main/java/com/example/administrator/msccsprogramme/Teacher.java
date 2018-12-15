package com.example.administrator.msccsprogramme;

public class Teacher {
    private String teacherName;
    private String teacherStatus;
    private String teacherResearchTitle;
    private String teacherResearch;

    public Teacher(String teacherName, String teacherStatus, String teacherResearchTitle, String teacherResearch){
        this.teacherName = teacherName;
        this.teacherStatus = teacherStatus;
        this.teacherResearchTitle = teacherResearchTitle;
        this.teacherResearch = teacherResearch;
    }

    public String getTeacherName() {
        return teacherName;
    }
    public String getTeacherStatus() {
        return teacherStatus;
    }
    public String getTeacherResearchTitle() {return teacherResearchTitle;}
    public String getTeacherResearch() {
        return teacherResearch;
    }
}
