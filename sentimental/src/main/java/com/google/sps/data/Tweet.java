package com.google.sps.data;

public final class Tweet {

  private final long id;
  private final String text;
  private final long timestamp;
  private double sentimentScore;
  private String city;

  public Tweet(long _id, String _text, long _timestamp, double _sentimentScore, String _city) {
    this.id = _id;
    this.text = _text;
    this.timestamp = _timestamp;
    this.sentimentScore = _sentimentScore;
    this.city = _city;
  }

  public Tweet(long _id, String _text, long _timestamp) {
    this(_id, _text, _timestamp, 0, "none");
  }

  public long getID() {
      return this.id;
  }

  public String getText() {
      return this.text;
  }

  public long getTimestamp() {
      return this.timestamp;
  }

  public double getSentimentScore() {
      return this.sentimentScore;
  }

  public void setSentimentScore(float sentimentScore) {
      this.sentimentScore = sentimentScore;
  }

  public String getCity(){
      return this.city;
  }

  public void setCity(String city){
      this.city = city;
  }
}
