package com.example.hongnhung.tytimeass.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by hongnhung on 26/02/2017.
 */

public class Headline implements Serializable {
    @SerializedName("main")
    public String Main;

    @SerializedName("name")
    public String Name;

    public String getMain() {
        return Main;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setMain(String main) {
        Main = main;
    }
}
