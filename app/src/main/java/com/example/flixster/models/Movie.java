package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    String backdropPath;
    String posterPath;
    String title;
    String overview;

    public Movie(JSONObject jsonObject) throws JSONException {
        backdropPath = jsonObject.getString( "backdrop_path" );
        posterPath = jsonObject.getString( "poster_path" );
        title = jsonObject.getString( "title" );
        overview = jsonObject.getString( "overview" );
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for ( int i = 0; i < movieJsonArray.length(); i++ ) {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }

        return movies;
    }

    // Make our code useful
    // URL of poster_part in the NOW_PLAYING_API is relative path
    // CONFIGURATION API Response
    // Appending what size the image is available to the the base URL
    // and then appending relative path (URL)
    public String getPosterPath() {
        // %s - here that is replaced by the posterPath
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getBackdropPath() {
        return String.format( "https://image.tmdb.org/t/p/w342/%s", backdropPath );
    }
    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

}
