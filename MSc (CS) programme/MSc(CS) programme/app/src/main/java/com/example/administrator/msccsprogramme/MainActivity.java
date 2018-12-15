package com.example.administrator.msccsprogramme;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private List<MainItem> mainItemList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
        LinearLayout mainLinearLayout = (LinearLayout) findViewById(R.id.main_linearLayout);
        mainLinearLayout.getBackground().setAlpha(150);
        initMainItems();
        RecyclerView mainItemRecyclerView = (RecyclerView) findViewById(R.id.mainItem_recycler_view);

        GridLayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 2);
        mainItemRecyclerView.setLayoutManager(layoutManager);
        MainItemAdapter mainItemAdapter = new MainItemAdapter(mainItemList);
        mainItemRecyclerView.setAdapter(mainItemAdapter);

        mainItemAdapter.setOnClick(new MainItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent;
                switch (mainItemList.get(position).getName()){
                    case "Programme Overview":
                        intent = new Intent(MainActivity.this, OverviewActivity.class);
                        startActivity(intent);
                        break;
                    case "Message from Director":
                        intent = new Intent(MainActivity.this, MsgDirectorActivity.class);
                        startActivity(intent);
                        break;
                    case "Programme Schedule":
                        intent = new Intent(MainActivity.this,ScheduleActivity.class);
                        startActivity(intent);
                        break;
                    case "Composite\nFees":
                        intent = new Intent(MainActivity.this, FeeActivity.class);
                        startActivity(intent);
                        break;
                    case "Faculty":
                        intent = new Intent(MainActivity.this, TeacherListActivity2.class);
                        startActivity(intent);
                        break;
                    case "Courses":
                        intent = new Intent(MainActivity.this, CoursesActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;

                }
            }
        });
    }

    private void initMainItems(){
        MainItem overview = new MainItem("Programme Overview", R.drawable.ic_programme_overview);
        mainItemList.add(overview);
        MainItem messageDirector = new MainItem("Message from Director", R.drawable.ic_message_director);
        mainItemList.add(messageDirector);
        MainItem schedule = new MainItem("Programme Schedule", R.drawable.ic_program_schedule);
        mainItemList.add(schedule);
        MainItem fees = new MainItem("Composite\nFees", R.drawable.ic_composite_fee);
        mainItemList.add(fees);
        MainItem teacherList = new MainItem("Faculty", R.drawable.ic_teacher_list);
        mainItemList.add(teacherList);
        MainItem courseList = new MainItem("Courses", R.drawable.ic_course_list);
        mainItemList.add(courseList);

    }
}
