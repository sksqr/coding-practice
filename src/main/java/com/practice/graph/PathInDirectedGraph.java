package com.practice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class PathInDirectedGraph {

  public static void main(String[] args) {
    System.out.println(solve(5,getInput()));
  }

  public static int solve(int A, ArrayList<ArrayList<Integer>> B) {
    Map<Integer, List<Integer>> map = new HashMap();
    Set<Integer> processed = new HashSet<>();
    int n=B.size();
    for(int i=0; i<n; i++){
      if(map.get(B.get(i).get(0))==null){
        map.put(B.get(i).get(0), new ArrayList());
      }
      map.get(B.get(i).get(0)).add(B.get(i).get(1));
    }
    Queue<Integer> queue = new LinkedList();
    queue.add(1);
    while(!queue.isEmpty()){
      int num = queue.poll();
      if(num==A){
        return 1;
      }
      if(!processed.contains(num)){
        if(map.get(num)!=null){
          queue.addAll(map.get(num));
        }
        processed.add(num);
      }
    }
    return 0;
  }


  private static ArrayList<ArrayList<Integer>>  getInput() {
    ArrayList<ArrayList<Integer>> listArrayList = new ArrayList<>();

//    int[][] A = {  {1, 2},        {4, 1},        {2, 4},        {3, 4},        {5, 2},        {1, 3} };

    int[][] A = {  {1, 2},       {2, 3},        {3, 4},        {4, 5},        };


    for(int i=0;i<A.length;i++){
      ArrayList<Integer> list = new ArrayList<>();
      for(int j=0; j<A[i].length;j++){
        list.add(A[i][j]);
      }
      listArrayList.add(list);
    }
    return listArrayList;
  }


}
