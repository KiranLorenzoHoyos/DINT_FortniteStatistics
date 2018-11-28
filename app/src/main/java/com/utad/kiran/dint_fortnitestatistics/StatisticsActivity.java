package com.utad.kiran.dint_fortnitestatistics;

import android.arch.lifecycle.ViewModelProviders;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

public class StatisticsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager recyclerViewLayoutManager;
    private StatisticsViewModel statisticsViewModel;
    private StatisticsAdapter statisticsAdapter;
    private FloatingActionButton floatingActionButton;
    private EditText statisticsNickname;
    private Spinner spinner;
    private String statisticsPlatform;
    private String statisticsNicknameUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        statisticsNickname = findViewById(R.id.statisticsNickname);
        spinner = findViewById(R.id.spinner);
        floatingActionButton = findViewById(R.id.buttonGo);
        changeData("","");
        onclick();
    }

    private void changeData(String statisticsPlatform,String statisticsNicknameUser){
        statisticsViewModel = ViewModelProviders.of(this).get(StatisticsViewModel.class);
        statisticsViewModel.statisticsData.observe(this, statisticsObjectData -> {
            if(statisticsObjectData!=null){
                Log.d("Service","Changes: "+statisticsObjectData);
                generateStatisticsList(statisticsObjectData);
            }
        });
        statisticsViewModel.getData(statisticsPlatform, statisticsNicknameUser);
    }

    private void onclick(){
        floatingActionButton.setOnClickListener(v -> {
            statisticsPlatform = spinner.getSelectedItem().toString();
            statisticsNicknameUser = statisticsNickname.getText().toString();
            statisticsViewModel.getData(statisticsPlatform, statisticsNicknameUser);
        });
    }

    private void generateStatisticsList(List<StatisticsRank> listStatistics) {
        recyclerView = findViewById(R.id.statisticsRecyclerView);
        statisticsAdapter = new StatisticsAdapter(listStatistics);
        recyclerViewLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        recyclerView.setAdapter(statisticsAdapter);
    }
}
