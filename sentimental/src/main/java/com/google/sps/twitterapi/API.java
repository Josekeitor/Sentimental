package com.google.sps.twitterapi;

import com.google.sps.data.Tweet;
import twitter4j.*;
import twitter4j.auth.*;
import java.util.List;
import java.util.ArrayList;

public class API{
    Twitter twitterAPI = TwitterFactory.getSingleton();

    public ArrayList<Tweet> searchTweets(String keyword){
        ArrayList<Tweet> tweets = new ArrayList<>();
        try {

            QueryResult result = search(keyword);
            List<Status> rawTweets = extractTweets(result);

            for (Status rawTweet: rawTweets
                 ) {
                Tweet newTweet = new Tweet(
                    rawTweet.getId(), 
                    rawTweet.getText(), 
                    rawTweet.getCreatedAt().getTime(), 
                    rawTweet.getGeoLocation().getLatitude(), 
                    rawTweet.getGeoLocation().getLongitude()
                    );
                tweets.add(newTweet);
            }

        } catch (TwitterException e) {
            System.out.println("Error while performing search: "+e.getErrorMessage());
        }
        return tweets;

    }

    private QueryResult search(String keyword) throws TwitterException {
        Query query = new Query(keyword);
        return twitterAPI.search(query);
    }

    private List<Status> extractTweets(QueryResult result){
        return result.getTweets();
    }
}
