package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class RunningMedian {

  int totalElements=0;

  PriorityQueue<Integer> maxHeap;

  PriorityQueue<Integer> minHeap;

  public RunningMedian() {
    minHeap = new PriorityQueue<Integer>();
    maxHeap = new PriorityQueue<Integer>((integer, t1) -> t1-integer);
  }

  public Integer getMedian(Integer num){
    if(totalElements==0){
      maxHeap.add(num);
      totalElements++;
      return num;
    }
    if(maxHeap.size() == minHeap.size()){
      if(num < maxHeap.peek()){
        maxHeap.add(num);
        return maxHeap.peek();
      }
      else {
        minHeap.add(num);
        return minHeap.peek();
      }
    }
    else if(maxHeap.size() < minHeap.size()){
      if(maxHeap.peek() < num){
        maxHeap.add(minHeap.poll());
        minHeap.add(num);
      }
      else{
        maxHeap.add(num);
      }
      return (maxHeap.peek()+minHeap.peek())/2;
    }
    else {
      if(maxHeap.peek() < num){
        minHeap.add(num);
      }
      else{
        minHeap.add(maxHeap.poll());
        maxHeap.add(num);
      }
      return (maxHeap.peek()+minHeap.peek())/2;
    }
  }


  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8));
    RunningMedian runningMedian = new RunningMedian();
    list.forEach(i -> System.out.println(runningMedian.getMedian(i)));
  }


}
