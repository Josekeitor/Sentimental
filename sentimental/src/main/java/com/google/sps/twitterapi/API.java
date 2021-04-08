package com.google.sps.twitterapi;

import com.google.sps.data.Tweet;
import twitter4j.*;
import twitter4j.auth.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class API{
    Twitter twitterAPI = TwitterFactory.getSingleton();
    HashMap<String, GeoLocation> mexicanCities = populateCities();
    public ArrayList<Tweet> searchTweets(String keyword){
        ArrayList<Tweet> tweets = new ArrayList<>();
        
        try {
            for (String city : mexicanCities.keySet()) {
                QueryResult result = search(keyword, city);
                List<Status> rawTweets = extractTweets(result);

            for (Status rawTweet: rawTweets
                 ) {
<<<<<<< HEAD
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
=======
                Tweet newTweet = new Tweet(rawTweet.getId(), rawTweet.getText(), rawTweet.getCreatedAt().getTime());
                newTweet.setCity(city);
>>>>>>> 4ae7a29fec8174e9fbe67a7fec08c3002a5c04cb
                tweets.add(newTweet);
                System.out.println(newTweet.getCity());
            }
            }
           

        } catch (TwitterException e) {
            System.out.println("Error while performing search: "+e.getErrorMessage());
        }
        return tweets;

    }

<<<<<<< HEAD
    private QueryResult search(String keyword) throws TwitterException {
        //Query query = new Query(keyword);
        Query query = new Query().geoCode(new GeoLocation(19.432608, -99.133209), 50, Query.KILOMETERS); 
        query.count(10);
=======
    private QueryResult search(String keyword, String city) throws TwitterException {
        Query query = new Query(keyword);
        GeoLocation geo = mexicanCities.get(city);
        query.setGeoCode(geo, 50, Query.Unit.km);
>>>>>>> 4ae7a29fec8174e9fbe67a7fec08c3002a5c04cb
        return twitterAPI.search(query);
    }

    private List<Status> extractTweets(QueryResult result){
        return result.getTweets();
    }

    private HashMap<String, GeoLocation> populateCities(){
        HashMap<String, GeoLocation> cities = new HashMap<>();
        GeoLocation geo = new GeoLocation(19.42847, -99.12766);
        cities.put("Ciudad de Mexico", geo);
        geo = new GeoLocation(25.67507, -100.31847);
        cities.put("Monterrey", geo);
        geo = new GeoLocation(20.66682, -103.39182);
        cities.put("Guadalajara", geo);


        return cities;
    }
}
