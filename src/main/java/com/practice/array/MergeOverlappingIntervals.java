package com.practice.array;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;




public class MergeOverlappingIntervals {

  public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
    Stack<Interval> stack = new Stack();
    ArrayList<Interval> result = new ArrayList();
    Collections.sort(intervals, (i1,i2)->i1.start-i2.start);
    int n= intervals.size();
    for(int i=0;i<n;i++){
      Interval interval = intervals.get(i);
      if(stack.isEmpty()){
        stack.push(interval);
      }
      else{
        Interval top = stack.peek();
        if(interval.start <= top.end){
          if(interval.end > top.end){
            top.end = interval.end;
            stack.pop();
            stack.push(top);
          }
        }
        else{
          stack.push(interval);
        }

      }
    }
    while(!stack.isEmpty()){
      result.add(stack.pop());
    }
    Collections.sort(result, (i1,i2)->i1.start-i2.start);
    return result;
  }

}
