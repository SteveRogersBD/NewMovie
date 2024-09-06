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
import com.example.movieapplication.models.Movie;
import com.example.movieapplication.models.TopMoviesResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TopMoviesAdapter extends RecyclerView.Adapter<TopMoviesAdapter.ViewHolder>{
    Context context;
    List<TopMoviesResponse.Datum> movies;

    public TopMoviesAdapter(Context context, List<TopMoviesResponse.Datum> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.streaming_movie,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TopMoviesResponse.Datum movie = movies.get(position);
        holder.tvRating.setText(movie.ratingsSummary.aggregateRating+"");
        holder.tvName.setText(movie.originalTitleText.text);
        //holder.moviePoster.setImageResource(movie.getImage());
        Picasso.get().load(movie.primaryImage.imageUrl).into(holder.moviePoster);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvRating, tvName;
        ImageView moviePoster;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRating=itemView.findViewById(R.id.tv_rating);
            tvName=itemView.findViewById(R.id.tv_moviename);
            moviePoster=itemView.findViewById(R.id.poster);

        }
    }
}
