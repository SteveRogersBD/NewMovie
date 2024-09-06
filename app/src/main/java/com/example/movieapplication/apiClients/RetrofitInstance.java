package com.example.movieapplication.apiClients;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    public static Retrofit topMovRetrofit = new Retrofit.Builder().baseUrl("https://imdb188.p.rapidapi.com/api/v1/").
            addConverterFactory(GsonConverterFactory.create()).build();

}
