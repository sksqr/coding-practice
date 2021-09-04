package com.test;
//task1
import java.util.PriorityQueue;

public class NBulbs {

  public static void main(String[] args) {
    int[] A ={1,2,3,4,5};
    System.out.println(solution(A));
  }

  public static int solution(int[] A) {
    // write your code in Java SE 8
    int n=A.length;
    int lightReached=0;
    PriorityQueue<Integer> queue = new PriorityQueue();
    int count =0;
    for(int i=0; i<n; i++){
      if(A[i]-lightReached == 1){
        count++;
        lightReached=A[i];
        while( !queue.isEmpty() && queue.peek()-lightReached==1){
          lightReached=queue.poll();
        }
      }
      else{
        queue.add(A[i]);
      }
    }
    return count;
  }

}
