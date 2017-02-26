package com.example.hongnhung.tytimeass.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hongnhung on 26/02/2017.
 */

public class Article implements Parcelable {


    @SerializedName("web_url")
    public String WebUrl;

    @SerializedName("snippet")
    public String Snippet;

    @SerializedName("lead_paragraph")
    public String LeadPara;


    @SerializedName("multimedia")
    List<Multimedia> listMultimedias;


    @SerializedName("headline")
    public Headline headline;


    @SerializedName("pub_date")
    public String PubDate;

    public Headline getHeadline() {
        return headline;
    }

    public void setHeadline(Headline headline) {
        this.headline = headline;
    }

    @SerializedName("document_type")
    public String Type;

    public Article() {

    }

    protected Article(Parcel in) {
        WebUrl = in.readString();
        Snippet = in.readString();
        LeadPara = in.readString();
        PubDate = in.readString();
        Type = in.readString();
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(WebUrl);
        dest.writeString(Snippet);
        dest.writeString(LeadPara);
        dest.writeString(PubDate);
        dest.writeString(Type);
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getWebUrl() {
        return WebUrl;
    }

    public void setWebUrl(String webUrl) {
        WebUrl = webUrl;
    }

    public String getSnippet() {
        return Snippet;
    }

    public void setSnippet(String snippet) {
        Snippet = snippet;
    }

    public String getLeadPara() {
        return LeadPara;
    }

    public void setLeadPara(String leadPara) {
        LeadPara = leadPara;
    }

    public List<Multimedia> getListMultimedias() {
        return listMultimedias;
    }

    public void setListMultimedias(List<Multimedia> listMultimedias) {
        this.listMultimedias = listMultimedias;
    }


    public String getPubDate() {
        return PubDate;
    }

    public void setPubDate(String pubDate) {
        PubDate = pubDate;
    }
}
