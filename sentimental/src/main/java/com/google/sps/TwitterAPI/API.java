package com.google.sps.TwitterAPI;
import com.google.sps.data.Tweet;
import twitter4j.*;

import java.util.ArrayList;
import java.util.List;


public class API{
    Twitter twitterAPI = TwitterFactory.getSingleton();

    public ArrayList<Tweet> searchTweets(String keyword){
        ArrayList<Tweet> tweets = new ArrayList<>();
        try {

            QueryResult result = search(keyword);
            List<Status> rawTweets = extractTweets(result);

            for (Status rawTweet: rawTweets
                 ) {
                System.out.println("vibe check");
                double langitude = 0.0;
                double longitude = 0.0;
                if(rawTweet.getGeoLocation() != null) {
                    langitude = rawTweet.getGeoLocation().getLatitude();
                    longitude = rawTweet.getGeoLocation().getLongitude();
                }
                Tweet newTweet = new Tweet(
                    rawTweet.getId(), 
                    rawTweet.getText(), 
                    rawTweet.getCreatedAt().getTime(), 
                    langitude, 
                    longitude
                    );
                tweets.add(newTweet);
            }

        } catch (TwitterException e) {
            System.out.println("Error while performing search: "+e.getErrorMessage());
        }
        return tweets;

    }

    private QueryResult search(String keyword) throws TwitterException {
        //Query query = new Query(keyword);
        Query query = new Query().geoCode(new GeoLocation(19.432608, -99.133209), 50, Query.KILOMETERS); 
        query.count(10);
        return twitterAPI.search(query);
    }

    private List<Status> extractTweets(QueryResult result){
        return result.getTweets();
    }
}