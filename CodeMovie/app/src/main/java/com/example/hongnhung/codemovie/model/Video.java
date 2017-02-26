package com.example.hongnhung.codemovie.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by hongnhung on 2/19/17.
 */

public class Video implements Serializable {
    @SerializedName("name")
    public String name;

    @SerializedName("size")
    public String size;

    @SerializedName("source")
    public String source;

    @SerializedName("type")
    public String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
