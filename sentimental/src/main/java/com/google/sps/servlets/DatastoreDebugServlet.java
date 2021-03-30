package com.google.sps.servlets;

import com.google.sps.data.DatastoreService;
import com.google.sps.data.Tweet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Prints a table of Tweets stored in Datastore, used for debugging. */
@WebServlet("/datastore-debug")
public class DatastoreDebugServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    // Store some fake tweets for testing.
    // NOTE: We probably want to delete this before we deploy this code to the
    // live site!
    List<Tweet> input = new ArrayList<>();
    input.add(new Tweet(1, "hello", 1000));
    input.add(new Tweet(2, "abc", 2000));
    input.add(new Tweet(3, "xyz", 3000));

    DatastoreService datastoreService = new DatastoreService();
    datastoreService.saveTweets(input);

    List<Tweet> output = datastoreService.getAllTweets();

    response.setContentType("text/html;");
    response.getWriter().println("<table>");
    response.getWriter().println("<tr>");
    response.getWriter().println("<th>ID</th>");
    response.getWriter().println("<th>Text</th>");
    response.getWriter().println("<th>Timestamp</th>");
    response.getWriter().println("</tr>");
    for(Tweet tweet : output) {
      response.getWriter().println("<tr>");
      response.getWriter().println("<td>" + tweet.getID() + "</td>");
      response.getWriter().println("<td>" + tweet.getText() + "</td>");
      response.getWriter().println("<td>" + tweet.getTimestamp() + "</td>");
      response.getWriter().println("</tr>");
    }
    response.getWriter().println("</table>");
  }
}
