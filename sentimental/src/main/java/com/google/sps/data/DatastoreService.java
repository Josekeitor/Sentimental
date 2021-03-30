package com.google.sps.data;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import java.util.ArrayList;
import java.util.List;

public class DatastoreService {

  /** Returns a List of all of the Tweets stored in Datastore, newest first. */
  public List<Tweet> getAllTweets() {
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    Query<Entity> query =
      Query.newEntityQueryBuilder().setKind("Tweet").setOrderBy(OrderBy.desc("timestamp")).build();
    QueryResults<Entity> results = datastore.run(query);

    List<Tweet> tweets = new ArrayList<>();
    while (results.hasNext()) {
      Entity entity = results.next();

      long id = entity.getKey().getId();
      String text = entity.getString("text");
      long timestamp = entity.getLong("timestamp");

      Tweet tweet = new Tweet(id, text, timestamp);
      tweets.add(tweet);
    }

    return tweets;
  }

  /**
   * Saves the Tweets in Datastore. Tweets with duplicate IDs will not be
   * repeated, so this is safe to call with the same Tweets multiple times.
   */
  public void saveTweets(List<Tweet> tweets) {
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Tweet");

    for (Tweet tweet : tweets) {
      FullEntity taskEntity =
          Entity.newBuilder(keyFactory.newKey(tweet.getID()))
              .set("text", tweet.getText())
              .set("timestamp", tweet.getTimestamp())
              .build();
      datastore.put(taskEntity);
    }
  }
}