package com.google.sps.data;

public final class Tweet {

  private final long id;
  private final String text;
  private final long timestamp;
  private final double langitude;
  private final double longitude;
  private double sentimentScore;

  public Tweet(long _id, String _text, long _timestamp, double _lang, double _long, double _sentimentScore) {
    this.id = _id;
    this.text = _text;
    this.timestamp = _timestamp;
    this.langitude = _lang;
    this.longitude = _long;
    this.sentimentScore = _sentimentScore;
  }

  public Tweet(long _id, String _text, long _timestamp, double _lang, double _long) {
    this(_id, _text, _timestamp, _lang, _long, 0);
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

  public double getLangitude() {
      return this.langitude;
  }

  public double getLongitude() {
      return this.longitude;
  }

  public double getSentimentScore() {
      return this.sentimentScore;
  }

  public void setSentimentScore(float sentimentScore) {
      this.sentimentScore = sentimentScore;
  }
}
