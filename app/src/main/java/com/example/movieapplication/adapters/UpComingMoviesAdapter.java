package com.example.movieapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapplication.R;
import com.example.movieapplication.models.UpComingMoviesResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UpComingMoviesAdapter extends RecyclerView.Adapter<UpComingMoviesAdapter.UpComingViewHolder>{

    Context context;
    List<UpComingMoviesResponse.Entry>list;

    public UpComingMoviesAdapter(Context context, List<UpComingMoviesResponse.Entry> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public UpComingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.upcoming_movies,parent,false);
        return new UpComingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UpComingViewHolder holder, int position) {
        UpComingMoviesResponse.Entry movie = list.get(position);

        // Check if movie is null
        if (movie != null) {
            // Check if imageModel is null
            UpComingMoviesResponse.ImageModel imageModel = movie.imageModel;
            if (imageModel != null) {
                String url = imageModel.url;

                // Check if URL is null
                if (url != null) {
                    // Load image using Picasso
                    Picasso.get()
                            .load(url)
                            .resize(200, 350)
                            .into(holder.moviePoster);
                } else {
                    // Set a placeholder if URL is null
                    holder.moviePoster.setImageResource(R.drawable.movieposter);
                }
            } else {
                // Set a placeholder if imageModel is null
                holder.moviePoster.setImageResource(R.drawable.movieposter);
            }
        } else {
            // Set a placeholder if movie is null
            holder.moviePoster.setImageResource(R.drawable.movieposter);
        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class UpComingViewHolder extends RecyclerView.ViewHolder {
        ImageView moviePoster;
        public UpComingViewHolder(@NonNull View itemView) {
            super(itemView);
            moviePoster = itemView.findViewById(R.id.poster_up);
        }
    }
}
