package com.practice.heapsandmap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ProfitMaximisation {

  public int solve(ArrayList<Integer> A, int B) {

    PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer integer, Integer t1) {
        return t1-integer;
      }
    });
    int n=A.size();
    for(int i=0;i<n;i++){
      queue.add(A.get(i));
    }
    int profit =0 ;
    while (B>0){
      int ticketCost = queue.poll();
      profit += ticketCost;
      B--;
      queue.add(ticketCost-1);
    }
    return profit;

  }

}
