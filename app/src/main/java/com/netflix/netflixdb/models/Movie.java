package com.netflix.netflixdb.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Movie {
    public String getPosterPath() {
        return String.format("Https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return Overview;
    }

    String posterPath;
    String originalTitle;
    String Overview;

    public Movie(JSONObject jsonObject) throws JSONException{
    this.posterPath = jsonObject.getString("poster_path");
    this.originalTitle = jsonObject.getString("original_title");
    this.Overview = jsonObject.getString("overview");

    }

    public static ArrayList<Movie> fromJSONArray(JSONArray array){
        ArrayList<Movie> result = new ArrayList<>();
        int x;
        for( x = 0; x < array.length(); x++);

        try {
            result.add(new Movie(array.getJSONObject(x)));
        } catch (JSONException e) {
            e.printStackTrace();
        }
      return result;
    }
}
