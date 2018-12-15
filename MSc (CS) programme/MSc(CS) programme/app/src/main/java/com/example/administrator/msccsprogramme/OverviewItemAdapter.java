package com.example.administrator.msccsprogramme;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class OverviewItemAdapter extends RecyclerView.Adapter<OverviewItemAdapter.ViewHolder> {
    private List<OverviewItem> mOverviewItemList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout overviewItemLayout;
        TextView overviewItemTitle;
        TextView overviewItemContent;

        public ViewHolder(View view) {
            super(view);
            overviewItemLayout = (LinearLayout) view.findViewById(R.id.overview_layout);
            overviewItemTitle = (TextView) view.findViewById(R.id.overview_title);
            overviewItemContent = (TextView) view.findViewById(R.id.overview_content);
        }
    }

    public OverviewItemAdapter(List<OverviewItem> overviewItemList){
        mOverviewItemList = overviewItemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.overviewitem_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position){
        OverviewItem overviewItem = mOverviewItemList.get(position);
//        holder.overviewItemLayout.setBackgroundResource(overviewItem.getBackgroundID());
//        holder.overviewItemLayout.getBackground().setAlpha(150);
        holder.overviewItemTitle.setText(overviewItem.getTitle());
        holder.overviewItemContent.setText(overviewItem.getContentID());
    }

    @Override
    public int getItemCount(){
        return mOverviewItemList.size();
    }
}
