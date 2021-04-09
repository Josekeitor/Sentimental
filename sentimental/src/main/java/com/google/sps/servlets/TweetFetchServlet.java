package com.google.sps.servlets;

import com.google.gson.Gson;
import com.google.sps.data.DatastoreService;
import com.google.sps.data.Tweet;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fetch-tweets")
public class TweetFetchServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        DatastoreService datastoreService = new DatastoreService();
        List<Tweet> tweets = datastoreService.getAllTweets();
        
        Gson gson = new Gson();
        String json = gson.toJson(tweets);

        response.setContentType("application/json;");
        response.getWriter().println(json);
    }
}
