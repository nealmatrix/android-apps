package com.example.administrator.msccsprogramme;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.List;

public class TeacherAdapter extends ArrayAdapter<Teacher> {
    private int resourceId;

    public TeacherAdapter(Context context, int resourceId, List<Teacher> teacherList){
        super(context, resourceId, teacherList);
        this.resourceId = resourceId;
    }
    class ViewHolder{
        TextView teacherName;
        TextView teacherStatus;
        TextView teacherResearchTitle;
        TextView teacherResearch;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Teacher teacher= getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.teacherName = (TextView) view.findViewById(R.id.teacher_name);
            viewHolder.teacherStatus= (TextView) view.findViewById(R.id.teacher_status);
            viewHolder.teacherResearchTitle = (TextView) view.findViewById(R.id.teacher_research_title);
            viewHolder.teacherResearch = (TextView) view.findViewById(R.id.teacher_research);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.teacherName.setText(teacher.getTeacherName());
        viewHolder.teacherStatus.setText(teacher.getTeacherStatus());
        viewHolder.teacherResearchTitle.setText(teacher.getTeacherResearchTitle());
        viewHolder.teacherResearch.setText(teacher.getTeacherResearch());
        return view;
    }
}