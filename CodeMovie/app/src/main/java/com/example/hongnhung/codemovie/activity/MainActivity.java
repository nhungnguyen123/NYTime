package com.example.hongnhung.codemovie.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RatingBar;

import com.example.hongnhung.codemovie.R;
import com.example.hongnhung.codemovie.adapter.ChoiceMovie;
import com.example.hongnhung.codemovie.adapter.MovieAdapter;
import com.example.hongnhung.codemovie.api.MovieApi;
import com.example.hongnhung.codemovie.model.Movie;
import com.example.hongnhung.codemovie.model.NowPlaying;
import com.example.hongnhung.codemovie.utils.Contants;
import com.example.hongnhung.codemovie.utils.RetrofitUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {


    @Bind(R.id.lvMovie)
    ListView lvMovie;

    @Bind(R.id.pbLoad)
    ProgressBar pbLoad;

    @Bind(R.id.swipeContainer)
    SwipeRefreshLayout swipeContainer;

    public MovieAdapter movieAdapter;

    List<Movie> movieList = new ArrayList<>();
    MovieApi movieApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        movieApi = RetrofitUtils.get().create(MovieApi.class);
//        if (savedInstanceState == null) {
            callMovie();
//        } else {
//
//        }

// call swipe
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchTimelineAsync(0);
                swipeContainer.setRefreshing(false);

                Log.e("callfrees", "pk");
            }

        });


    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putParcelable();
//    }

    public void callMovie() {
        movieApi.getNowPlaying().enqueue(new Callback<NowPlaying>() {
            @Override
            public void onResponse(Call<NowPlaying> call, Response<NowPlaying>
                    response) {
                Log.d("respon", response.isSuccessful() + "");
                movieList = response.body().getMovies();
                movieAdapter = new MovieAdapter(MainActivity.this, movieList);
                lvMovie.setAdapter(movieAdapter);
                movieAdapter.setChoiceMovie(new ChoiceMovie() {
                    @Override
                    public void SetMovie(Movie movieInfo) {
                        changeActivity(movieInfo);
                    }
                });

            }

            @Override
            public void onFailure(Call<NowPlaying> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }

    public void changeActivity(Movie movie) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra(Contants.STATIC_CHANGE, movie);
        startActivity(intent);
    }

    public void fetchTimelineAsync(int page) {
        movieAdapter.clear();
        callMovie();
        movieAdapter.addAll(movieList);
    }


}
