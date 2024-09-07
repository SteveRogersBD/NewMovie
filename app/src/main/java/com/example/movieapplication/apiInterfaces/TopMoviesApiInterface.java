package com.example.movieapplication.apiInterfaces;

import com.example.movieapplication.models.StreamingMoviesResponse;
import com.example.movieapplication.models.TopMoviesResponse;
import com.example.movieapplication.models.UpComingMoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface TopMoviesApiInterface {

    @GET("getWeekTop10")
    @Headers({
            "x-rapidapi-key: 353b66e372mshc1bc6556a7cb404p1b2297jsn6230a7927dd4",
            "x-rapidapi-host: imdb188.p.rapidapi.com"
    })
    Call<TopMoviesResponse> getTopMovies();

    @GET("getWhatsStreaming")
    @Headers({
            "x-rapidapi-key: 353b66e372mshc1bc6556a7cb404p1b2297jsn6230a7927dd4",
            "x-rapidapi-host: imdb188.p.rapidapi.com"
    })
    Call<StreamingMoviesResponse> getStreamingMovies(@Query("country") String country);

    @GET("getUpcomingMovies")
    @Headers({
            "x-rapidapi-key: 353b66e372mshc1bc6556a7cb404p1b2297jsn6230a7927dd4",
            "x-rapidapi-host: imdb188.p.rapidapi.com"
    })
    Call<UpComingMoviesResponse> getUpComingMovies(@Query("country") String country);


}
