package com.example.administrator.msccsprogramme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;


public class TitleLayout extends LinearLayout {
    public TitleLayout(Context context, AttributeSet attrs){
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.title, this);

        Button titleBack = (Button) findViewById(R.id.title_back);
        TextView titleText = (TextView) findViewById(R.id.title_text);
        Button titleChat = (Button) findViewById(R.id.title_chat);

        titleBack.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                ((Activity) getContext()).finish();
            }
        });

        String text = attrs.getAttributeValue("http://schemas.android.com/apk/res/android", "text");
        titleText.setText(text);

        titleChat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getContext(), ChatActivity.class);
                ((Activity)getContext()).startActivity(intent);
            }
        });
    }
}

