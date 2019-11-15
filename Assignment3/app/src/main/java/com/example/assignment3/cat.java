package com.example.assignment3;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class cat{
    @SerializedName("imageResource")
    @Expose
    private int imageResource;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("temperament")
    @Expose
    private String temperament;

    @SerializedName("imperial_weight")
    @Expose
    private String imperial_weight;


    @SerializedName("origin")
    @Expose
    private String origin;

    public int getImageResource() {
        return imageResource;
    }

    public String getName() {
        return name;
    }


    public String getImperial_weight() {
        return imperial_weight;
    }

    public String getTemperament() {
        return temperament;
    }

    public String getOrigin() {
        return origin;
    }

    public cat (int imageResource, String name, String temperament, String origin, String imperial_weight ) {
        this.name = name;
        this.temperament = temperament;
        this.imperial_weight = imperial_weight;
        this.origin = origin;
        this.imageResource = imageResource;

    }
}
