package com.example.administrator.msccsprogramme;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class OverviewActivity extends BaseActivity {
    private List<OverviewItem> overviewItemList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
        
        initOverviewItems();
        RecyclerView overviewItemRecyclerView = (RecyclerView) findViewById(R.id.overviewItem_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        overviewItemRecyclerView.setLayoutManager(layoutManager);
        OverviewItemAdapter overviewItemAdapter = new OverviewItemAdapter(overviewItemList);
        overviewItemRecyclerView.setAdapter(overviewItemAdapter);
    }

    private void initOverviewItems(){
        OverviewItem programme_overview = new OverviewItem(R.drawable.po_programme_overview, "Programme Overview", R.string.programme_overview);
        overviewItemList.add(programme_overview);
        OverviewItem information_security = new OverviewItem(R.drawable.po_information_security, "Cyber Security", R.string.cyber_security);
        overviewItemList.add(information_security);
        OverviewItem multimedia_computing = new OverviewItem(R.drawable.po_multimedia_computing, "Multimedia Computing", R.string.multimedia_computing);
        overviewItemList.add(multimedia_computing);
        OverviewItem financial_computing = new OverviewItem(R.drawable.po_financial_computing,"Financial Computing",R.string.financial_computing);
        overviewItemList.add(financial_computing);
        OverviewItem general_stream = new OverviewItem(R.drawable.po_general_stream,"General Stream",R.string.general_stream);
        overviewItemList.add(general_stream);
    }
}
   
