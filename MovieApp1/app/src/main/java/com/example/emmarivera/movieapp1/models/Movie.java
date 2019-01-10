package com.example.emmarivera.movieapp1.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Movie {

    // values from the API
    private String title;
    private String overview;
    private String posterPath; // only the path

    // initialize from JSON data
    public Movie(JSONObject object) throws JSONException {
        title = object.getString("title"); // remember key's have to match exactly!
        overview = object.getString("overview");
        posterPath = object.getString("poster_path");
    }

    /** NOTE: because these variables were declared private we
     *  need to create getters to expose this data to expose this data
     *  to the activity
     **/

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getPosterPath() {
        return posterPath;
    }
}
