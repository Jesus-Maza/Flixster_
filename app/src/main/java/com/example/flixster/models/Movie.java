package com.example.flixster.models;

//import android.hardware.lights.LightState;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {

    int movieId;
    String posterPath;
    String overview;
    String Title;
    String backDropPath;
    double rating;

    // empty constructor needed by the Parceler library
    public Movie(){};

    public Movie(JSONObject jsonObject) throws JSONException {
        posterPath = jsonObject.getString("poster_path");
        backDropPath = jsonObject.getString("backdrop_path");
        Title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        rating = jsonObject.getDouble("vote_average");
        movieId = jsonObject.getInt("id");

    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for(int i = 0; i < movieJsonArray.length(); i++ ){
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public double getRating() {
        return rating;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }
    public  String getBackDropPath(){
        return String.format("https://image.tmdb.org/t/p/w342/%s", backDropPath);
    }
    public String getOverview() {
        return overview;
    }

    public String getTitle() {
        return Title;
    }

    public int getMovieId() {
        return movieId;
    }
}
