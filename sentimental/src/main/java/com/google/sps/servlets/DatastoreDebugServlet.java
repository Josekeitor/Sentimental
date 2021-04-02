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

    DatastoreService datastoreService = new DatastoreService();
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
