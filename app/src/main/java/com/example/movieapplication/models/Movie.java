package com.example.movieapplication.models;

import android.graphics.drawable.Drawable;

public class Movie {
    String name;
    int image;
    float rating;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Movie(String name, int image, float rating) {
        this.name = name;
        this.image = image;
        this.rating = rating;
    }
}
