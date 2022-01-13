package com.practice.greedy;

import com.practice.array.Interval;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DisjointIntervals {

  public static void main(String[] args) {
    DisjointIntervals disjointIntervals = new DisjointIntervals();
    ArrayList<ArrayList<Integer>> A = getInput();
    System.out.println(disjointIntervals.solve(A));
  }

  public int solve(ArrayList<ArrayList<Integer>> A) {
    List<Interval> list = new ArrayList<>();
    int n = A.size();
    for(int i=0; i<n; i++){
      list.add(new Interval(A.get(i).get(0),A.get(i).get(1)));
    }
    Collections.sort(list, (i1,i2)->i1.end-i2.end);
    Stack<Interval> results = new Stack<>();
    results.push(list.get(0));

    for(int i=1;i<n;i++){
      Interval top = results.peek();
      if(!isOverlaping(top,list.get(i))){
        results.push(list.get(i));
      }
    }
    return results.size();
  }


  private boolean isOverlaping(Interval i1, Interval i2){
    if(i1.start <= i2.start && i2.start <= i1.end){
      return true;
    }
    if(i2.start <= i1.start && i1.start <= i2.end){
      return true;
    }
    return false;
  }



  private static ArrayList<ArrayList<Integer>>  getInput() {
    ArrayList<ArrayList<Integer>> listArrayList = new ArrayList<>();

//    int[][] A = {  {1, 2},        {4, 1},        {2, 4},        {3, 4},        {5, 2},        {1, 3} };

    int[][] A = {
        {3, 13},
        {7, 7},
        {3, 10},
        {4, 8},
        {7, 8},
        {9, 12},
        {3, 6},
        {7, 12},
        {4, 10},
        {3, 8},
        {5, 11},
        {9, 10},
        {3, 7},
        {4, 4},
        {7, 15},
        {2, 9},
    };


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
