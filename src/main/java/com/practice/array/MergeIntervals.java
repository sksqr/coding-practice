package com.practice.array;
/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

Example 2:

Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

  public static void main(String[] args) {
    List<Integer> starts= Arrays.asList(1,2);
    List<Integer> end= Arrays.asList(3,6);
    ArrayList<Interval> intervals = getIntervals(starts,end);
    Interval interval = new Interval(8,10);
    ArrayList<Interval> updated = insert(intervals,interval);
    System.out.println(updated);
  }


  public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
    ArrayList<Interval> result = new ArrayList<>();
    int i=0;
    int n=intervals.size();
    while (i<n && newInterval.start > intervals.get(i).start && newInterval.start > intervals.get(i).end){
      result.add(intervals.get(i));
      i++;
    }
    if(i<n && intervals.get(i).start < newInterval.start && intervals.get(i).end > newInterval.start){
      intervals.get(i).end = Math.max(intervals.get(i).end,newInterval.end);
      result.add(intervals.get(i));
      i++;
    }
    else {
      result.add(newInterval);
    }

    while (i<n){
      if(intervals.get(i).start< result.get(result.size()-1).end){
        result.get(result.size()-1).end=intervals.get(i).end;
        i++;
      }
      else{
        result.add(intervals.get(i));
        i++;
      }
    }
    return result;
  }

  private static ArrayList<Interval> getIntervals(List<Integer> start, List<Integer> end){
    ArrayList<Interval> list = new ArrayList<>();
    int n = start.size();
    for(int i=0;i<n;i++){
      list.add(new Interval(start.get(i),end.get(i)));
    }
    return list;
  }
}
