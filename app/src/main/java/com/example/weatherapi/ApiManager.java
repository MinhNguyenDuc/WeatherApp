package com.example.weatherapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiManager {
    public static String BASE_URL = "http:/dateservice.accuweather.com";

    @GET("/forescasts/v1/hourly/12hour/353412")
    Call<List<Weather>> getHour();

    @GET("/forescasts/v1/daily/5day/353412")
    Call<List<Weather>> getDay();
}
