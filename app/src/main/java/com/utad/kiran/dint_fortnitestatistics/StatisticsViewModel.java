package com.utad.kiran.dint_fortnitestatistics;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class StatisticsViewModel extends ViewModel {
    private StatisticsRepository statisticsRepository = StatisticsRepository.getInstance();
    public MutableLiveData<List<StatisticsRank>> statisticsData = new MutableLiveData<>();
    public List<StatisticsRank> dataList = new ArrayList<>();

    public void getData(String statisticsPlatform, String statisticsNicknameUser) {
        statisticsRepository.getStatisticsInfo(statisticsPlatform, statisticsNicknameUser)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new io.reactivex.Observer<StatisticsUser>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(StatisticsUser statisticsObject) {
                        if (statisticsObject != null) {
                            dataList.clear();
                            StatisticsValue data = statisticsObject.getStats().getP2();
                            dataList.add(data.getScore());
                            dataList.add(data.getScorePerMatch());
                            dataList.add(data.getMatches());
                            dataList.add(data.getKills());
                            statisticsData.postValue(dataList);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("Service error", "Error: " + e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
