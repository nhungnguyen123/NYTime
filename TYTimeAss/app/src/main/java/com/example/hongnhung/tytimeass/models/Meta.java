package com.example.hongnhung.tytimeass.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hongnhung on 26/02/2017.
 */

public class Meta {
    @SerializedName("hits")
    public String hits;

    @SerializedName("time")
    public String time;

    @SerializedName("offset")
    public String offest;

    public String getHits() {
        return hits;
    }

    public void setHits(String hits) {
        this.hits = hits;
    }

    public String getOffest() {
        return offest;
    }

    public void setOffest(String offest) {
        this.offest = offest;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
