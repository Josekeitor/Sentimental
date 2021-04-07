package com.google.sps.servlets;

import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.Sentiment;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import twitter4j.*;
import com.google.sps.data.Tweet;
import java.util.List;
import java.util.ArrayList;
import com.google.sps.twitterapi.API;
import com.google.sps.data.DatastoreService;

@WebServlet("/sentiment")
public class SentimentServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    API readTweets = new API();
    ArrayList<Tweet> tweets = readTweets.searchTweets("Hello");
    System.out.println(tweets.get(0).getText());
    
    for(int i = 0; i < tweets.size(); i++){
      Tweet tweet = tweets.get(i);
      String message = tweet.getText();

        Document doc =
            Document.newBuilder().setContent(message).setType(Document.Type.PLAIN_TEXT).build();
        LanguageServiceClient languageService = LanguageServiceClient.create();
        Sentiment sentiment = languageService.analyzeSentiment(doc).getDocumentSentiment();
        tweet.setSentimentScore(sentiment.getScore());
        languageService.close();
    }

    DatastoreService ds = new DatastoreService();
    ds.saveTweets(tweets);

    // Output the sentiment score as HTML.
    // A real project would probably store the score alongside the content.
    response.setContentType("text/html;");
    //response.getWriter().println("<h1>Sentiment Analysis</h1>");
    //response.getWriter().println("<p>You entered: " + message + "</p>");
    response.getWriter().println("<ol>");
    for(Tweet tweet : tweets){
      response.getWriter().println("<li>Tweet: " + tweet.getText() + "</li>");
      response.getWriter().println("<li>Sentiment analysis score: " + tweet.getSentimentScore() + "</li>");
    }
    response.getWriter().println("</ol>");
    
    //response.getWriter().println("<p><a href=\"/\">Back</a></p>");
  }
}
