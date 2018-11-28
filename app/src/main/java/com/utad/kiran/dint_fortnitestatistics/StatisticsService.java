package com.utad.kiran.dint_fortnitestatistics;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface StatisticsService {
    @Headers("TRN-Api-Key: 9eda2a1c-4c4b-4667-b9d3-d88c50d557fd")
    @GET("profile/{platform}/{epic-nickname}")
    io.reactivex.Observable<StatisticsUser> getStatisticsInfo(@Path("platform") String statisticsPlatform, @Path("epic-nickname") String statisticsNicknameUser);

    static StatisticsService Factory(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(" https://api.fortnitetracker.com/v1/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return  retrofit.create(StatisticsService.class);
    }
}
