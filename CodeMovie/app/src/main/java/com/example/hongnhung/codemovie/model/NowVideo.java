package com.example.hongnhung.codemovie.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hongnhung on 2/19/17.
 */

public class NowVideo {
    @SerializedName("youtube")
    private List<Video> videos;

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}
