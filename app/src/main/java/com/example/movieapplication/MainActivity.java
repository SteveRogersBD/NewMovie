package com.example.movieapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.movieapplication.adapters.StreamingMoviesAdapter;
import com.example.movieapplication.adapters.TopMoviesAdapter;
import com.example.movieapplication.apiClients.RetrofitInstance;
import com.example.movieapplication.apiInterfaces.TopMoviesApiInterface;
import com.example.movieapplication.databinding.ActivityMainBinding;
import com.example.movieapplication.models.Movie;
import com.example.movieapplication.models.StreamingMoviesResponse;
import com.example.movieapplication.models.TopMoviesResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayList<TopMoviesResponse.Datum>movies;
    TopMoviesApiInterface topMoviesApiInterface;
    List<StreamingMoviesResponse.Edge>pagerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        movies = new ArrayList<>();


        topMoviesApiInterface = RetrofitInstance.topMovRetrofit.create(TopMoviesApiInterface.class);
        topMoviesApiInterface.getTopMovies().enqueue(new Callback<TopMoviesResponse>() {
            @Override
            public void onResponse(Call<TopMoviesResponse> call, Response<TopMoviesResponse> response) {
                if(response.body()!=null && response.isSuccessful())
                {
                    try{
                        TopMoviesResponse res = (TopMoviesResponse) response.body();
//                        for(int i=0;i<10;i++)
//                        {
//                            movies.add(res.data.get(i));
//                        }
                        movies = res.data;
                        TopMoviesAdapter adapter = new TopMoviesAdapter(MainActivity.this, movies);
                        binding.streamingRecycler.setAdapter(adapter);
                        LinearLayoutManager lm = new LinearLayoutManager(MainActivity.this,
                                LinearLayoutManager.HORIZONTAL,false);
                        binding.streamingRecycler.setLayoutManager(lm);

                    }catch(Exception e){
                        Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TopMoviesResponse> call, Throwable throwable) {
                Toast.makeText(MainActivity.this, throwable.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });



        //viewpager logic
        topMoviesApiInterface.getStreamingMovies("us").enqueue(new Callback<StreamingMoviesResponse>() {
            @Override
            public void onResponse(Call<StreamingMoviesResponse> call, Response<StreamingMoviesResponse> response) {
                if(response.isSuccessful() && response.body()!=null)
                {
                    try{
                        pagerList = response.body().data.get(0).edges;
                        StreamingMoviesAdapter streamingMoviesAdapter = new StreamingMoviesAdapter(MainActivity.this,
                                pagerList);
                        binding.streamingPager.setAdapter(streamingMoviesAdapter);

                    }catch (Exception e)
                    {
                        Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<StreamingMoviesResponse> call, Throwable throwable) {
                Toast.makeText(MainActivity.this, throwable.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }
}