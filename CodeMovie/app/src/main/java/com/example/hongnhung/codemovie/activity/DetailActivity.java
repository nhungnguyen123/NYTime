package com.example.hongnhung.codemovie.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.hongnhung.codemovie.R;
import com.example.hongnhung.codemovie.api.MovieApi;
import com.example.hongnhung.codemovie.model.Movie;
import com.example.hongnhung.codemovie.model.NowVideo;
import com.example.hongnhung.codemovie.utils.Contants;
import com.example.hongnhung.codemovie.utils.RetrofitUtils;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.gson.Gson;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends YouTubeBaseActivity {

    @Bind(R.id.tv_titel)
    TextView mTvTitel;
    @Bind(R.id.tv_time)
    TextView mTvTime;
    @Bind(R.id.rb_start)
    RatingBar rbStart;
    @Bind(R.id.tv_description)
    TextView mDescription;

    @Bind(R.id.player)
    YouTubePlayerView mPlayer;


    Movie movie = null;
    MovieApi movieApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        movie = (Movie) getIntent().getSerializableExtra(Contants.STATIC_CHANGE);
        mDescription.setText(movie.getOverview());
        mTvTitel.setText(movie.getTitle());
        movieApi = RetrofitUtils.get().create(MovieApi.class);
        movieApi.getVideoCall().enqueue(new Callback<NowVideo>() {
            @Override
            public void onResponse(Call<NowVideo> call, Response<NowVideo> response) {
                Log.d("success", response.isSuccessful() + "");
                String gson = new Gson().toJson(response.body().getVideos().get(0).getName()) + "";
                Log.e("gson", gson);
            }

            @Override
            public void onFailure(Call<NowVideo> call, Throwable t) {

            }
        });


        // count ratingbar
        rbStart.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                Log.e("start", rating + "");

            }
        });

        mPlayer.initialize("AIzaSyCnAuJxk_5n5Vbc5-kr5XgqGJxFv4hHfaE",
                new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                        YouTubePlayer youTubePlayer, boolean b) {

                        // do any work here to cue video, play video, etc.
                        youTubePlayer.cueVideo("IwfUnkBfdZ4");
                    }

                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                        YouTubeInitializationResult youTubeInitializationResult) {

                    }
                });
        Log.e("StringName", movie.getTitle());
    }
}
