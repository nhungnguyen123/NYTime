package com.example.hongnhung.codemovie.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hongnhung on 2/18/17.
 */

public class NowPlaying {
    @SerializedName("results")
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
