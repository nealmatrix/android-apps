package com.example.administrator.msccsprogramme;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TeacherAdapter2 extends ArrayAdapter<Teacher2> {
    private int resourceId;

    public TeacherAdapter2(Context context, int resourceId, List<Teacher2> teacherList){
        super(context, resourceId, teacherList);
        this.resourceId = resourceId;
    }
    class ViewHolder{
        ImageView teacherImage;
        TextView teacherName;
        TextView teacherStatus;
        TextView teacherEmail;
        TextView teacherResearchTitle;
        TextView teacherResearch;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Teacher2 teacher= getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.teacherImage =(ImageView) view.findViewById(R.id.teacher_image);
            viewHolder.teacherName = (TextView) view.findViewById(R.id.teacher_name2);
            viewHolder.teacherStatus = (TextView) view.findViewById(R.id.teacher_status2);
            viewHolder.teacherEmail = (TextView) view.findViewById(R.id.teacher_email);
            viewHolder.teacherResearchTitle = (TextView) view.findViewById(R.id.teacher_research_title2);
            viewHolder.teacherResearch = (TextView) view.findViewById(R.id.teacher_research2);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.teacherImage.setVisibility(View.VISIBLE);
        viewHolder.teacherName.setVisibility(View.VISIBLE);
        if (teacher.getTeacherName().equals("")){
            viewHolder.teacherImage.setVisibility(View.GONE);
            viewHolder.teacherName.setVisibility(View.GONE);
        }
        viewHolder.teacherImage.setImageResource(teacher.getTeacherImage());
        viewHolder.teacherName.setText(teacher.getTeacherName());
        viewHolder.teacherStatus.setText(teacher.getTeacherStatus());
        viewHolder.teacherEmail.setText(teacher.getTeacherEmail());
        viewHolder.teacherResearchTitle.setText(teacher.getTeacherResearchTitle());
        viewHolder.teacherResearch.setText(teacher.getTeacherResearch());
        return view;
    }
}