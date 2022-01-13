package com.practice.array;

public class Interval {
  public int start;
  public int end;
  Interval() { start = 0; end = 0; }
  public Interval(int s, int e) { start = s; end = e; }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("{start=").append(start);
    sb.append(", end=").append(end);
    sb.append('}');
    return sb.toString();
  }
}
