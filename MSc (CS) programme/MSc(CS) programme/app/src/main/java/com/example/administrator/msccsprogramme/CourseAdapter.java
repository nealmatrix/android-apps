package com.example.administrator.msccsprogramme;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class CourseAdapter extends ArrayAdapter<Course> {
    private int resourceId;

    public CourseAdapter(Context context, int resourceId, List<Course> courseList){
        super(context, resourceId, courseList);
        this.resourceId = resourceId;
    }
    class ViewHolder{
        LinearLayout courseLayout;
        TextView courseIndex;
        TextView courseTitle;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Course course = getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.courseLayout = (LinearLayout) view.findViewById(R.id.course_item_layout);
            viewHolder.courseIndex = (TextView) view.findViewById(R.id.course_index);
            viewHolder.courseTitle = (TextView) view.findViewById(R.id.course_title);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.courseIndex.setText(course.getCourseIndex());
        viewHolder.courseTitle.setText(course.getCourseTitle());
        viewHolder.courseLayout.setBackgroundColor(((Activity)getContext()).getResources().getColor(course.getBackgroundColor()));
        return view;

    }
}
