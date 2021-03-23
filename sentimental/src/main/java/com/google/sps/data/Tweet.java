package main.java.com.google.sps.data;

public final class Tweet {

  private final long id;
  private final String text;
  private final long timestamp;
  private final float index;

  public Tweet(long _id, String _text, long _timestamp, float _index) {
    this.id = _id;
    this.text = _text;
    this.timestamp = _timestamp;
    this.index = _index;
  }
}