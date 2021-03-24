package main.java.com.google.sps.data;

public final class Tweet {

  private final long id;
  private final String text;
  private final long timestamp;
  private float index;

  public Tweet(long _id, String _text, long _timestamp) {
    this.id = _id;
    this.text = _text;
    this.timestamp = _timestamp;
    this.index = 0.0;
  }

  public String getID() {
      return this.id;
  }

  public String getText() {
      return this.text;
  }

  public String getTimestamp() {
      return this.timestamp;
  }

  public String getIndex() {
      return this.index;
  }

  public void setIndex(float _index) {
      this.index = _index;
  }
}