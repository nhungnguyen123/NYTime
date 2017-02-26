package com.example.hongnhung.tytimeass.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by hongnhung on 26/02/2017.
 */

public class Multimedia implements Serializable {
    @SerializedName("credit")
    public String Credit;

    @SerializedName("url")
    public String ImageUrl;

    @SerializedName("height")
    public String Height;

    @SerializedName("width")
    public String Width;

    @SerializedName("type")
    public String type;

    public String getCredit() {
        return Credit;
    }

    public void setCredit(String credit) {
        Credit = credit;
    }

    public String getImageUrl() {
        return "http://www.nytimes.com/" + ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getHeight() {
        return Height;
    }

    public void setHeight(String height) {
        Height = height;
    }

    public String getWidth() {
        return Width;
    }

    public void setWidth(String width) {
        Width = width;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
