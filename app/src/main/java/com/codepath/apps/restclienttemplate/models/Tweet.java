package com.codepath.apps.restclienttemplate.models;

import org.json.JSONArray;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;
@Parcel
public class Tweet {

    public String body;
    public String createdAt;
    public User user;
// Putting an empty constructor
    public Tweet(){

    }

    public static Tweet fromJson(JSONObject jsonObject) throws Exception{
        Tweet tweet = new Tweet();
        tweet.body = jsonObject.getString("text");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
        return tweet;
    }
    public static List<Tweet>fromJsonArray(JSONArray jsonArray) throws Exception{
        List<Tweet> tweets = new ArrayList<>();
        for (int i =0;i<jsonArray.length();i++){
          tweets.add(fromJson(jsonArray.getJSONObject(i)));
        }
        return tweets;
    }
}
