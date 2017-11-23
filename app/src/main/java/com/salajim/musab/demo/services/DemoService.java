package com.salajim.musab.demo.services;

import com.salajim.musab.demo.Constants;
import com.salajim.musab.demo.models.Demo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Musab on 11/22/2017.
 */

public class DemoService {
    public static void logos(String articles, Callback callback) {

        // Here we are creating OKHttpClient to create and send request
        OkHttpClient client = new OkHttpClient.Builder().build();

        //Building a new URL with OkHttp
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.GENERAL_BASE_URL).newBuilder();//Creates a new URL
        urlBuilder.addQueryParameter(Constants.QUERY_APIKEY_HOLDER, Constants.ApiKey);

        //Turns the finished URL into a string
        String url = urlBuilder.build().toString();

        //Creates a new request with OkHttp using the new url
        Request request = new Request.Builder()
                .url(url)
                .build();

        //We create a Call object and place the request in it
        Call call = client.newCall(request);
        call.enqueue(callback);// Then we excute the request
    }

    //This method returns an array of Entertainment news
    public ArrayList<Demo> processResults(Response response) {
        ArrayList<Demo> demos = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if(response.isSuccessful()) {
                JSONObject newsesJSON = new JSONObject(jsonData);
                JSONArray articlesJSON = newsesJSON.getJSONArray("articles");
                for(int i = 0; i < articlesJSON.length(); i++) {
                    JSONObject newsJSON = articlesJSON.getJSONObject(i);
                    String urlToImage = newsJSON.getString("urlToImage");
                    String title = newsJSON.getString("title");

                    Demo demo = new Demo(urlToImage, title);
                    demos.add(demo);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return demos;
    }
}
