package com.practice.facebook;

import java.util.ArrayList;
import java.util.List;

class Interval{
  int start;
  int end;

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Interval{");
    sb.append("start=").append(start);
    sb.append(", end=").append(end);
    sb.append('}');
    return sb.toString();
  }
}
public class MergeOverlappingIntervals {

  public static void main(String[] args) {
    List<Interval> list = new ArrayList<>();
//    list.add(new Interval(1,5));
//    list.add(new Interval(3,7));
//    list.add(new Interval(4,6));
//    list.add(new Interval(6,8));
    list.add(new Interval(10,12));
    list.add(new Interval(12,15));
    System.out.println(mergeIntervals(list));
  }

  public  static List<Interval> mergeIntervals(List<Interval> list){
    List<Interval> merged = new ArrayList<>();
    int n = list.size();
    int k=-1;
    for(int i=0;i<n;i++){
      if(k==-1){
        merged.add(list.get(i));
        k++;
      }
      else{
        Interval prev = merged.get(k);
        Interval curr = list.get(i);
        if(curr.start <= prev.end){
          prev.end = Math.max(curr.end,prev.end);
        }
        else {
          merged.add(curr);
          k++;
        }
      }
    }
    return merged;
  }

}
