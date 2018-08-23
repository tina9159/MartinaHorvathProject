package hu.horvath.martina.project.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {

    @SerializedName("results")
    List<Movie> results;

    public List<Movie> getResults() {
        return results;
    }
}
