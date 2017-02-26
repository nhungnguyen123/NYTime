package com.example.hongnhung.tytimeass.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hongnhung on 26/02/2017.
 */

public class ArticleNow implements Serializable{

    @SerializedName("docs")
    private List<Article> articleList;

    @SerializedName("meta")
    private Meta mMeta;

    public Meta getmMeta() {
        return mMeta;
    }

    public void setmMeta(Meta mMeta) {
        this.mMeta = mMeta;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }
}
