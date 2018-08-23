package hu.horvath.martina.project.data.model;

import com.google.gson.annotations.SerializedName;

public class MovieDetails {

    @SerializedName("budget")
    private String budget;
    @SerializedName("title")
    private String title;
    @SerializedName("overview")
    private String overview;
    @SerializedName("release_date")
    private String releaseDate;

    public String getBudget() {
        return budget;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
