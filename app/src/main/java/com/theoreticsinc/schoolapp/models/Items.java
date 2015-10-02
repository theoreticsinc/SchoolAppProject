package com.theoreticsinc.schoolapp.models;

/**
 * Created by Angelo on 9/30/2015.
 */
import com.google.gson.annotations.SerializedName;
public class Items {
    @SerializedName("details")
    public String details;

    @SerializedName("name")
    public String name;

    @SerializedName("id")
    public String id;

    @SerializedName("title")
    public String title;
}
