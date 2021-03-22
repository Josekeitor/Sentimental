import twitter4j.*;
import twitter4j.auth.*;

public class API{
    Twitter twitterAPI = TwitterFactory.getSingleton();
    // TODO: Read credentials from file and initialize twitterAPI with said credentials

    public QueryResult search(String keyword){
        Query query = new Query(keyword);
        return this.twitterAPI.search(query);
    }

    public Status[] extractTweets(QueryResult result){
        return result.getTweets();
    }
}