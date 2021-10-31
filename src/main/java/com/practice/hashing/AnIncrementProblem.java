package com.practice.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class AnIncrementProblem {

  public static void main(String[] args) {
    AnIncrementProblem anIncrementProblem = new AnIncrementProblem();
    List<Integer> list = Arrays.asList(1, 2, 3, 2, 3, 1, 4, 2, 1, 3 );
    //4 5 3 2 3 2 4 2 1 3
    System.out.println(anIncrementProblem.solve(new ArrayList<>(list)));
  }

  public ArrayList<Integer> solve(ArrayList<Integer> A) {
    Map<Integer, PriorityQueue<Integer>> map = new HashMap();
    int n = A.size();
    for(int i=0; i<n; i++){
      if(map.get(A.get(i)) == null){
        PriorityQueue<Integer> q =new PriorityQueue<>();
        q.add(i);
        map.put(A.get(i),q);
      }
      else{
        PriorityQueue<Integer> pq = map.get(A.get(i));
        if(!pq.isEmpty()){
          int index = pq.poll();
          int value = A.get(index)+1;
          A.set(index,value);
            pq.add(i);
          PriorityQueue<Integer> pq1 = map.get(value);
          if(pq1!=null){
            pq1.add(index);
          }
          else{
            PriorityQueue<Integer> q =new PriorityQueue<>();
            q.add(index);
            map.put(value,q);
          }
        }
        else{
          map.get(A.get(i)).add(i);
        }
      }
    }
    return A;
  }
}


