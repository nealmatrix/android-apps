package com.example.administrator.msccsprogramme;

public class Teacher2 {
    private int teacherImage;
    private String teacherName;
    private String teacherStatus;
    private String teacherEmail;
    private String teacherResearchTitle;
    private String teacherResearch;

    public Teacher2(int teacherImage,String teacherName, String teacherStatus, String teacherEmail , String teacherResearchTitle, String teacherResearch){
        this.teacherImage = teacherImage;
        this.teacherName = teacherName;
        this.teacherStatus = teacherStatus;
        this.teacherEmail = teacherEmail;
        this.teacherResearchTitle = teacherResearchTitle;
        this.teacherResearch = teacherResearch;
    }
    public int getTeacherImage() {return teacherImage;}
    public String getTeacherName() {
        return teacherName;
    }
    public String getTeacherStatus() {
        return teacherStatus;
    }
    public String getTeacherEmail() {return teacherEmail;}
    public String getTeacherResearchTitle() {return teacherResearchTitle;}
    public String getTeacherResearch() {
        return teacherResearch;
    }
}
