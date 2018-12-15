package com.example.administrator.msccsprogramme;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MainItemAdapter extends RecyclerView.Adapter<MainItemAdapter.ViewHolder> {
    private List<MainItem> mMainItemList;
    private OnItemClickListener onClick;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View mainItemView;
        ImageView mainItemImage;
        TextView mainItemName;

        public ViewHolder(View view) {
            super(view);
            mainItemView = view;
            mainItemImage = (ImageView) view.findViewById(R.id.mainItem_image);
            mainItemName = (TextView) view.findViewById(R.id.mainItem_name);
        }
    }

    public MainItemAdapter(List<MainItem> mainItemList){
        mMainItemList = mainItemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mainitem_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position){
        MainItem mainItem = mMainItemList.get(position);
        holder.mainItemImage.setImageResource(mainItem.getImageId());
        holder.mainItemName.setText(mainItem.getName());
        holder.mainItemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                onClick.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount(){
        return mMainItemList.size();
    }

    public void setOnClick(OnItemClickListener onClick){
        this.onClick = onClick;
    }

}
