package com.practice.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class DisjointSet
{
  private Map<Integer, Integer> parent = new HashMap();

  // perform MakeSet operation
  public void makeSet(int universe)
  {
    // create `n` disjoint sets (one for each item)
    for (int i=1; i<= universe; i++) {
      parent.put(i, i);
    }
  }

  // Find the root of the set in which element `k` belongs
  public int Find(int k)
  {
    // if `k` is root
    if (parent.get(k) == k) {
      return k;
    }

    // recur for the parent until we find the root
    return Find(parent.get(k));
  }

  // Perform Union of two subsets
  public void Union(int a, int b)
  {
    // find the root of the sets in which elements
    // `x` and `y` belongs
    int x = Find(a);
    int y = Find(b);

    parent.put(x, y);
  }
}

public class CommutableIslands {


  public static void main(String[] args) {
    CommutableIslands commutableIslands = new CommutableIslands();
    int len = commutableIslands.solve(4,getInput());
    System.out.println(len);
  }


  public int solve(int A, ArrayList<ArrayList<Integer>> B) {
    Collections.sort(B, new Comparator<ArrayList<Integer>>() {
      @Override
      public int compare(ArrayList<Integer> integers, ArrayList<Integer> t1) {
        return integers.get(2)-t1.get(2);
      }
    });
    int cost=0;
//    List<Set<Integer>> covered = new ArrayList<>();
    DisjointSet disjointSet = new DisjointSet();
    disjointSet.makeSet(A);


    int bridges = B.size();
    for(int i=0;i<bridges;i++){
      ArrayList<Integer> bridge = B.get(i);
      if(isAdded(bridge,disjointSet)){
        cost  = cost + bridge.get(2);
      }
    }
    return cost;
  }

  boolean isAdded(ArrayList<Integer> bridge, DisjointSet disjointSet){
    int set1 = disjointSet.Find(bridge.get(0));
    int set2 = disjointSet.Find(bridge.get(1));
    if(set1==set2){
      return false;
    }
    disjointSet.Union(bridge.get(0),bridge.get(1));
    return true;
  }

  boolean isAdded(ArrayList<Integer> bridge, List<Set<Integer>> covered){
    Set<Integer> fisrtSet = null;
    Set<Integer> secondSet = null;
    for(int i=0;i<covered.size(); i++){
      if(covered.get(i).contains(bridge.get(0))){
        fisrtSet = covered.get(i);
      }
      if(covered.get(i).contains(bridge.get(1))){
        secondSet = covered.get(i);
      }
    }
    if(fisrtSet==secondSet && fisrtSet !=null){
      return false;
    }
    if(fisrtSet!=secondSet && (fisrtSet !=null && secondSet!=null)){
      fisrtSet.addAll(secondSet);
      covered.remove(secondSet);
      return true;
    }
    if(fisrtSet!=null && secondSet==null){
      fisrtSet.add(bridge.get(1));
      return true;
    }
    if(fisrtSet==null && secondSet!=null){
      secondSet.add(bridge.get(0));
      return true;
    }
    Set<Integer> newSet = new HashSet<>();
    newSet.add(bridge.get(0));
    newSet.add(bridge.get(1));
    covered.add(newSet);
    return true;
  }


  private static ArrayList<ArrayList<Integer>>  getInput() {
    ArrayList<ArrayList<Integer>> listArrayList = new ArrayList<>();

//    int[][] A = {  {1, 2},        {4, 1},        {2, 4},        {3, 4},        {5, 2},        {1, 3} };
//
    int[][] A = {   {1, 2, 1},
        {2, 3, 4},
        {1, 4, 3},
        {4, 3, 2},
        {1, 3, 10}  };

//    int[][] A = {
//        {1, 2, 1},
//        {2, 3, 2},
//        {3, 4, 4},
//        {1, 4, 3},
//    };


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
