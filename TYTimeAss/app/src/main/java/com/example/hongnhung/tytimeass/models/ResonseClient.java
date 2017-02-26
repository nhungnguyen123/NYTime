package com.example.hongnhung.tytimeass.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hongnhung on 26/02/2017.
 */

public class ResonseClient {
    @SerializedName("response")
    public ArticleNow articleNow;

    public ArticleNow getArticleNow() {
        return articleNow;
    }

    public void setArticleNow(ArticleNow articleNow) {
        this.articleNow = articleNow;
    }
}
