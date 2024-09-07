package com.example.movieapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapplication.R;
import com.example.movieapplication.models.StreamingMoviesResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class StreamingMoviesAdapter extends RecyclerView.Adapter<StreamingMoviesAdapter.MovieViewHolder>{

    Context context;
    List<StreamingMoviesResponse.Edge>movies;

    public StreamingMoviesAdapter(Context context, List<StreamingMoviesResponse.Edge> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pager_item_layout,parent,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        StreamingMoviesResponse.Edge movie = movies.get(position);
        Picasso.get().load(movie.title.primaryImage.imageUrl).resize(350,200).
                into(holder.moviePoster);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView moviePoster;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            moviePoster = itemView.findViewById(R.id.poster_pager);
        }
    }
}
