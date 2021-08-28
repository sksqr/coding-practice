package com.practice.heapsandmap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KLargestElements {

  public static void main(String[] args) {
    ArrayList<Integer> minHeap = new ArrayList<>();

    minHeap.add(2);
    minHeap.add(1);
    minHeap.add(4);
    minHeap.add(3);

//    System.out.println(minHeap.poll());
    System.out.println(solve(minHeap,2));

  }


  public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
    PriorityQueue<Integer> minHeap = new PriorityQueue();
    int n = A.size();
    int i;
    for( i=0;i<B;i++){
      minHeap.add(A.get(i));
    }
    while(i<n){
      if(A.get(i) > minHeap.peek()){
        minHeap.poll();
        minHeap.add(A.get(i));
      }
      i++;
    }
    ArrayList<Integer> result = new ArrayList();
    while(!minHeap.isEmpty()){
      result.add(minHeap.poll());
    }
    return result;
  }

}
