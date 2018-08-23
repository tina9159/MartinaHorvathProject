package hu.horvath.martina.project.data.model;

import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("poster_path")
    private String poster;

    public String getPoster() {
        return poster;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
