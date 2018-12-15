package com.example.administrator.msccsprogramme;

import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TeacherListActivity extends BaseActivity {
    private List<Teacher> teacherList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_list);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
        initTeachers();
        TeacherAdapter teacherAdapter = new TeacherAdapter(TeacherListActivity.this,R.layout.teacher_item, teacherList);
        ListView teacherListView= (ListView) findViewById(R.id.teacher_list_view);
    //        courseListView.setBackgroundColor(getResources().getColor(R.color.HotPink));
            teacherListView.setAdapter(teacherAdapter);
    }
    private void initTeachers(){
//        Teacher t = new Course("COMP7806","Topic in information security",R.color.HotPink);
//        courseList.add(c);c
        try{
            InputStream inputStream = getResources().openRawResource(R.raw.teachers);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            String[] teacherInfo;
            Teacher teacher;
//            course = new Course(getResources().getString(R.string.course_introduction),"",color);
//            courseList.add(course);
            while ((line = bufferedReader.readLine())!=null){
                teacherInfo = line.split(";",-1);
                teacher = new Teacher(teacherInfo[0],teacherInfo[1],teacherInfo[2],teacherInfo[3]);
                teacherList.add(teacher);
            }
            bufferedReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
