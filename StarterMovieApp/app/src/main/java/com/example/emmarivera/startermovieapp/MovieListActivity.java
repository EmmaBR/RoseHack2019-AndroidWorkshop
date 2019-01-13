package com.example.emmarivera.startermovieapp;

import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MovieListActivity extends AppCompatActivity {

    // constants
    // base URL for the API
    public final static String API_BASE_URL = "https://api.themoviedb.org/3";
    // the parameter name for the API key
    public final static String API_KEY_PARAM = "api_key";
    // the API key -- TODO INSERT YOUR API KEY
    public final static String API_KEY = "";
    // tag for logging activity
    public final static String TAG = "MovieListActivity";

    // instantiate fields
    AsyncHttpClient client;

    // list of currently playing movies
    //ArrayList<Movie> movies;
    // the recycler view
    //RecyclerView rvMovies;
    // the adapter wired to the recycler view
    //MovieAdapter adapter;
    // image config
    //Config config;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        //initialize the client
        client = new AsyncHttpClient();
        // initialize the list of movies

        // initialize the adapter -- movies adapter cannot be reinitialized after this point


        // resolve the recycler view and connect layout manager




        // get configuration on creation

    }

    // get the configuration from the API
    private void getConfiguration() {
        // create the url
        String url = API_BASE_URL + "/configuration";
        // set the request parameters
        RequestParams params = new RequestParams();
        params.put(API_KEY_PARAM, API_KEY); // API key, always required
        // execute get request which expects a JSON object response in return
        client.get(url, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                //super.onSuccess(statusCode, headers, response);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                //super.onFailure(statusCode, headers, responseString, throwable);
                logError("Failed getting configuration", throwable, true);
            }
        });


    }

    // error logging helper to keep track of silent failures
    // handles errors, log and alert user
    private void logError(String message, Throwable error, boolean alertUser) {
        // always log the error
        Log.e(TAG, message, error);
        // alert the user
        if(alertUser) {
            // display a toast to the user
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        }

    }
}
