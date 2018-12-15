package com.example.administrator.msccsprogramme;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CoursesActivity extends BaseActivity {
    private List<Course> courseList = new ArrayList<>();
    private static final String TAG = "CoursesActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar !=null){
            actionBar.hide();
        }
        initCourses();
        CourseAdapter courseAdapter = new CourseAdapter(CoursesActivity.this, R.layout.course_item, courseList);
        ListView courseListView= (ListView) findViewById(R.id.course_list_view);
//        courseListView.setBackgroundColor(getResources().getColor(R.color.HotPink));
        courseListView.setAdapter(courseAdapter);
    }
    private void initCourses(){
//        Course c = new Course("COMP7806","Topic in information security",R.color.HotPink);
//        courseList.add(c);
        try{
            InputStream inputStream = getResources().openRawResource(R.raw.courses);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            String[] courseInfo;
            Course course;
            int color = R.color.white;
            course = new Course(getResources().getString(R.string.course_introduction),"",color);
            courseList.add(course);
            while ((line = bufferedReader.readLine())!=null){
                courseInfo = line.split(",",-1);
                Log.d(TAG, courseInfo[0]+courseInfo[1]);
                switch (courseInfo[0]){
                    case "Cyber Security":
                        color = R.color.HotPink;
                        break;
                    case "Financial Computing":
                        color = R.color.DeepSkyBlue;
                        break;
                    case "Multimedia Computing":
                        color = R.color.LimeGreen;
                        break;
                    case "Other Courses":
                        color = R.color.Gold;
                        break;
                    case "Capstone Experience":
                        color = R.color.Yellow;
                        break;
                    default:
                        break;
                }
                course = new Course(courseInfo[0],courseInfo[1],color);
                courseList.add(course);
            }
            course = new Course(getResources().getString(R.string.course_note),"", R.color.white);
            courseList.add(course);
            bufferedReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
