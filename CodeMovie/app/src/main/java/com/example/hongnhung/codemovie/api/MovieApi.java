package com.example.hongnhung.codemovie.api;

import com.example.hongnhung.codemovie.model.NowPlaying;
import com.example.hongnhung.codemovie.model.NowVideo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hongnhung on 2/18/17.
 */

public interface MovieApi {

    @GET("now_playing")
    Call<NowPlaying>getNowPlaying();

    @GET("209112/trailers")
    Call<NowVideo>getVideoCall();

}
