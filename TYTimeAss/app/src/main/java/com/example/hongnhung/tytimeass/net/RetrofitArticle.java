package com.example.hongnhung.tytimeass.net;

import android.util.Log;

import com.example.hongnhung.tytimeass.utils.Contants;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hongnhung on 26/02/2017.
 */

public class RetrofitArticle {

    public static  Retrofit get()
    {
        return new Retrofit.Builder()
                .baseUrl(Contants.URL)
                .client(client())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static OkHttpClient client()
    {
        return  new OkHttpClient.Builder()
                .addInterceptor(apiInterceptor())
                .build();

    }

    public static Interceptor apiInterceptor()
    {
        return  new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                HttpUrl url = request.url()
                        .newBuilder()
                        .addQueryParameter("api_key", Contants.API_KEY)
                        .build();
                request = request.newBuilder()
                        .url(url)
                        .build();
                Log.e("url", url + "");
                return chain.proceed(request);
            }
        };
    }

}
