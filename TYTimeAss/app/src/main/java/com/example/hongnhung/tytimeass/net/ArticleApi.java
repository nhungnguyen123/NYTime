package com.example.hongnhung.tytimeass.net;

import com.example.hongnhung.tytimeass.models.ArticleNow;
import com.example.hongnhung.tytimeass.models.ResonseClient;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by hongnhung on 26/02/2017.
 */

public interface ArticleApi {

    @GET("articlesearch.json")
    Call<ResonseClient> getArticle(@QueryMap( encoded = true)Map<String, String>options);
}
