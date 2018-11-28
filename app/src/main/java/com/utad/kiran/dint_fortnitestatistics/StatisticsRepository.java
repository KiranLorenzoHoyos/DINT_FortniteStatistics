package com.utad.kiran.dint_fortnitestatistics;

import io.reactivex.Observable;

public class StatisticsRepository {
    private static volatile StatisticsRepository ourInstance = new StatisticsRepository();
    private StatisticsService statisticsService = StatisticsService.Factory();

    private StatisticsRepository() {

    }

    static StatisticsRepository getInstance() {
        if (ourInstance == null) {
            synchronized (StatisticsRepository.class) {
                if (ourInstance == null) {
                    ourInstance = new StatisticsRepository();
                }
            }
        }
        return ourInstance;
    }

    public Observable<StatisticsUser> getStatisticsInfo(String statisticsPlatform, String statisticsNicknameUser){
        return statisticsService.getStatisticsInfo(statisticsPlatform, statisticsNicknameUser);
    }

}
