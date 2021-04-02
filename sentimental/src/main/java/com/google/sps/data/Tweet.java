package com.google.sps.data;

public final class Tweet {

  private final long id;
  private final String text;
  private final long timestamp;
  private double sentimentScore;

  public Tweet(long _id, String _text, long _timestamp, double _sentimentScore) {
    this.id = _id;
    this.text = _text;
    this.timestamp = _timestamp;
    this.sentimentScore = _sentimentScore;
  }

  public Tweet(long _id, String _text, long _timestamp) {
    this(_id, _text, _timestamp, 0);
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
}
